package com.organization.Auto_TEC.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.Auto_TEC.Entities.Departamentos;
import com.organization.Auto_TEC.Entities.Rol;
import com.organization.Auto_TEC.Entities.administradorEntitie;
import com.organization.Auto_TEC.Repository.AdministradorRepository;
import com.organization.Auto_TEC.Repository.DepartamentosRepository;
import com.organization.Auto_TEC.Repository.RolRepository;

@Service
public class AdminService {

    private final AdministradorRepository administradorRepository;
    private final RolRepository rolRepository;
    private final DepartamentosRepository departamentosRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdministradorRepository administradorRepository,
                      RolRepository rolRepository,
                      DepartamentosRepository departamentosRepository,
                      PasswordEncoder passwordEncoder) {
        this.administradorRepository = administradorRepository;
        this.rolRepository = rolRepository;
        this.departamentosRepository = departamentosRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public administradorEntitie crearAdministrador(String username, String email, String password, 
                                                 String nombres, String apellidos) {
        
        // Verificar si ya existe
        if (administradorRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        
        if (administradorRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        // Buscar rol ADMIN
        Rol rolAdmin = rolRepository.findByNombre("ADMIN")
                .orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"));

        // Buscar departamento
        Departamentos departamento = departamentosRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No hay departamentos disponibles"));

        // Crear administrador
        administradorEntitie admin = new administradorEntitie();
        admin.setUsername(username);
        admin.setEmail(email);
        admin.setPasswordHash(passwordEncoder.encode(password));
        admin.setRol(rolAdmin);
        admin.setDepartamento(departamento);
        admin.setActivo(true);

        return administradorRepository.save(admin);
    }

    @Transactional
    public administradorEntitie crearAdministradorSimple(String username, String email, String password) {
        return crearAdministrador(username, email, password, "Admin", "User");
    }
}