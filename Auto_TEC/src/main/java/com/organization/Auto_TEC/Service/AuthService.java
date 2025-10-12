package com.organization.Auto_TEC.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.Auto_TEC.DTO.LoginResponseDTO;
import com.organization.Auto_TEC.DTO.RegistroDTO;
import com.organization.Auto_TEC.Entities.Departamentos;
import com.organization.Auto_TEC.Entities.Rol;
import com.organization.Auto_TEC.Entities.Sesiones;
import com.organization.Auto_TEC.Entities.usuarioEntitie;
import com.organization.Auto_TEC.Repository.DepartamentosRepository;
import com.organization.Auto_TEC.Repository.RolRepository;
import com.organization.Auto_TEC.Repository.SesionRepository;
import com.organization.Auto_TEC.Repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepo;
    private final SesionRepository sesionRepo;
    private final RolRepository rolRepository;
    private final DepartamentosRepository departamentosRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepo, 
                      SesionRepository sesionRepo, 
                      RolRepository rolRepository,
                      DepartamentosRepository departamentosRepository,
                      PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.sesionRepo = sesionRepo;
        this.rolRepository = rolRepository;
        this.departamentosRepository = departamentosRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // MÉTODO DE REGISTRO CORREGIDO
    @Transactional
    public usuarioEntitie registrarUsuario(RegistroDTO registroDTO) {
        // Verificar si el usuario ya existe
        if (usuarioRepo.existsByUsername(registroDTO.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        if (usuarioRepo.existsByEmail(registroDTO.getEmail())) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }

        // Buscar el rol CLIENTE
        Rol rolCliente = rolRepository.findByNombre("CLIENTE")
                .orElseThrow(() -> new RuntimeException("Rol CLIENTE no encontrado en la base de datos"));

        // Buscar departamento por defecto
        Departamentos departamentoDefault = departamentosRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No hay departamentos disponibles en la base de datos"));

        // Crear nuevo usuario
        usuarioEntitie usuario = new usuarioEntitie();
        usuario.setUsername(registroDTO.getUsername());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setPasswordHash(passwordEncoder.encode(registroDTO.getPassword()));
        usuario.setNombres(registroDTO.getNombres());
        usuario.setApellidos(registroDTO.getApellidos());
        usuario.setRol(rolCliente);
        usuario.setActivo(true);
        
        return usuarioRepo.save(usuario);
    }

    // MÉTODO DE LOGIN CORREGIDO
    @Transactional
    public LoginResponseDTO loginSoloUnaSesion(String usernameOrEmail, String rawPassword, boolean kickPrevious, String ip, String userAgent) {
        
        // ✅ CORREGIDO: Usar el método correcto del repository
        usuarioEntitie user = usuarioRepo
                .findByUsernameOrEmail(usernameOrEmail) // ✅ Solo un parámetro
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Verificar si el usuario está activo
        if (!user.isActivo()) {
            throw new IllegalArgumentException("Usuario desactivado");
        }

        // Verificar contraseña
        if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }

        // Revisar si existe sesión activa
        Optional<Sesiones> actual = sesionRepo.findFirstByUsuario_IdAndActivaTrue(user.getId());
        if (actual.isPresent()) {
            Sesiones s = actual.get();
            if (s.getFechaExpiracion().isAfter(OffsetDateTime.now())) {
                if (!kickPrevious) {
                    return new LoginResponseDTO(
                            null,
                            s.getFechaExpiracion(),
                            user.getId(),
                            "Ya tienes una sesión activa."
                    );
                } else {
                    s.setActiva(false);
                    s.setFechaCierre(OffsetDateTime.now()); // ✅ Usar fechaCierre en lugar de fechaCreacion
                    sesionRepo.save(s);
                }
            } else {
                // Sesión expirada, desactivar
                s.setActiva(false);
                s.setFechaCierre(OffsetDateTime.now());
                sesionRepo.save(s);
            }
        }

        // Crear nueva sesión
        OffsetDateTime ahora = OffsetDateTime.now();
        Sesiones nueva = new Sesiones();
        nueva.setUsuario(user);
        nueva.setSessionToken(UUID.randomUUID().toString());
        nueva.setFechaCreacion(ahora);
        nueva.setFechaExpiracion(ahora.plusHours(1));
        nueva.setActiva(true);
        nueva.setIpAddress(ip);
        nueva.setUserAgent(userAgent);

        try {
            sesionRepo.save(nueva);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Error al crear la sesión: " + e.getMessage(), e);
        }

        // Actualizar último login del usuario
        user.setUltimoLogin(ahora);
        usuarioRepo.save(user);

        return new LoginResponseDTO(
                nueva.getSessionToken(),
                nueva.getFechaExpiracion(),
                user.getId(),
                "Login correcto"
        );
    }

    // Método adicional para logout
    @Transactional
    public void logout(String sessionToken) {
        Sesiones sesion = sesionRepo.findBySessionTokenAndActivaTrue(sessionToken)
                .orElseThrow(() -> new IllegalArgumentException("Sesión no encontrada o ya cerrada"));
        
        sesion.setActiva(false);
        sesion.setFechaCierre(OffsetDateTime.now());
        sesionRepo.save(sesion);
    }

    // Método para verificar sesión activa
    public boolean verificarSesionActiva(String sessionToken) {
        Optional<Sesiones> sesion = sesionRepo.findBySessionTokenAndActivaTrue(sessionToken);
        return sesion.isPresent() && sesion.get().getFechaExpiracion().isAfter(OffsetDateTime.now());
    }
}