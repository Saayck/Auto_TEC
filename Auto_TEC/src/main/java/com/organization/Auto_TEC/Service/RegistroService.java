package com.organization.Auto_TEC.Service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.Auto_TEC.DTO.RegistroDTO;
import com.organization.Auto_TEC.Entities.Departamentos;
import com.organization.Auto_TEC.Entities.Rol;
import com.organization.Auto_TEC.Entities.usuarioEntitie;
import com.organization.Auto_TEC.Repository.DepartamentosRepository;
import com.organization.Auto_TEC.Repository.RolRepository;
import com.organization.Auto_TEC.Repository.UsuarioRepository;

@Service
public class RegistroService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final DepartamentosRepository departamentosRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistroService(UsuarioRepository usuarioRepository, 
                         RolRepository rolRepository,
                         DepartamentosRepository departamentosRepository,
                         PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.departamentosRepository = departamentosRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String registrarUsuario(RegistroDTO registroDTO) {
        try {
            if (usuarioRepository.existsByUsername(registroDTO.getUsername())) {
                return "El nombre de usuario ya está en uso";
            }
            
            if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
                return "El correo electrónico ya está en uso";
            }

            // Buscar rol CLIENTE
            Optional<Rol> rolCliente = rolRepository.findByNombre("CLIENTE");
            if (rolCliente.isEmpty()) {
                return "Error en la configuración del sistema: Rol CLIENTE no encontrado";
            }

            // Buscar el primer departamento disponible
            Optional<Departamentos> departamentoDefault = departamentosRepository.findAll()
                .stream()
                .findFirst();
                
            if (departamentoDefault.isEmpty()) {
                // Si no hay departamentos, crear uno por defecto
                Departamentos nuevoDepartamento = new Departamentos();
                nuevoDepartamento.setNombre("Clientes");
                departamentosRepository.save(nuevoDepartamento);
                departamentoDefault = Optional.of(nuevoDepartamento);
            }

            // Crear nuevo usuario
            usuarioEntitie usuario = new usuarioEntitie();
            usuario.setUsername(registroDTO.getUsername());
            usuario.setEmail(registroDTO.getEmail());
            usuario.setPasswordHash(passwordEncoder.encode(registroDTO.getPassword()));
            usuario.setNombres(registroDTO.getNombres());
            usuario.setApellidos(registroDTO.getApellidos());
            usuario.setRol(rolCliente.get());
            usuario.setActivo(true);

            usuarioRepository.save(usuario);
            return null; // null indica éxito
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error interno del servidor al registrar el usuario";
        }
    }
}