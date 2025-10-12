package com.organization.Auto_TEC.Service;

import java.util.List;
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
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final DepartamentosRepository departamentosRepository; 
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, 
                             RolRepository rolRepository,
                             DepartamentosRepository departamentosRepository,
                             PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.departamentosRepository = departamentosRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<usuarioEntitie> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<usuarioEntitie> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public usuarioEntitie save(usuarioEntitie usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<usuarioEntitie> findClientes() {
        return usuarioRepository.findByRolNombre("CLIENTE");
    }

    @Override
    public List<usuarioEntitie> findVendedores() {
        return usuarioRepository.findByRolNombre("VENDEDOR");
    }

    @Override
    public List<usuarioEntitie> findByActivoTrue() {
        return usuarioRepository.findByActivoTrue();
    }

    @Override
    @Transactional
    public usuarioEntitie registrarUsuario(RegistroDTO registroDTO) {
        // Verificar si el usuario ya existe
        if (usuarioRepository.existsByUsername(registroDTO.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }

        // Buscar el rol CLIENTE
        Rol rolCliente = rolRepository.findByNombre("CLIENTE")
                .orElseThrow(() -> new RuntimeException("Rol CLIENTE no encontrado"));

        // BUSCAR UN DEPARTAMENTO POR DEFECTO - IMPORTANTE
        Departamentos departamento = departamentosRepository.findById(1L) // Cambia 1L por el ID de un departamento existente
                .orElseGet(() -> {
                    // Si no existe el departamento 1, toma el primero que encuentre
                    return departamentosRepository.findAll().stream()
                            .findFirst()
                            .orElse(null);
                });

        if (departamento == null) {
            departamento = new Departamentos();
            departamento.setNombre("General");
            departamento = departamentosRepository.save(departamento);
        }

        // Crear nuevo usuario
        usuarioEntitie usuario = new usuarioEntitie();
        usuario.setUsername(registroDTO.getUsername());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setPasswordHash(passwordEncoder.encode(registroDTO.getPassword()));
        usuario.setNombres(registroDTO.getNombres());
        usuario.setApellidos(registroDTO.getApellidos());
        usuario.setRol(rolCliente);
        usuario.setDepartamento(departamento); // Ahora nunca será null
        usuario.setActivo(true);

        return usuarioRepository.save(usuario);
    }
}