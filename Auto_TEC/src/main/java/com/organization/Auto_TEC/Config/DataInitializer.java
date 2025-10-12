package com.organization.Auto_TEC.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.organization.Auto_TEC.Entities.Departamentos;
import com.organization.Auto_TEC.Entities.Rol;
import com.organization.Auto_TEC.Entities.administradorEntitie;
import com.organization.Auto_TEC.Entities.usuarioEntitie;
import com.organization.Auto_TEC.Repository.AdministradorRepository;
import com.organization.Auto_TEC.Repository.DepartamentosRepository;
import com.organization.Auto_TEC.Repository.RolRepository;
import com.organization.Auto_TEC.Repository.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;
    private final DepartamentosRepository departamentosRepository;
    private final AdministradorRepository administradorRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(RolRepository rolRepository,
                          DepartamentosRepository departamentosRepository,
                          AdministradorRepository administradorRepository,
                          UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder) {
        this.rolRepository = rolRepository;
        this.departamentosRepository = departamentosRepository;
        this.administradorRepository = administradorRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        crearRoles();
        crearDepartamentos();
        crearAdministradorPorDefecto();
        // crearUsuarioAdministrador(); // Opcional: también crear usuario con rol ADMIN
    }

    private void crearRoles() {
        if (rolRepository.findByNombre("ADMIN").isEmpty()) {
            Rol adminRol = new Rol();
            adminRol.setNombre("ADMIN");
            rolRepository.save(adminRol);
            System.out.println("✅ Rol ADMIN creado");
        }

        if (rolRepository.findByNombre("CLIENTE").isEmpty()) {
            Rol clienteRol = new Rol();
            clienteRol.setNombre("CLIENTE");
            rolRepository.save(clienteRol);
            System.out.println("✅ Rol CLIENTE creado");
        }
    }

    private void crearDepartamentos() {
        if (departamentosRepository.count() == 0) {
            Departamentos departamento = new Departamentos();
            departamento.setNombre("Administración");
            departamentosRepository.save(departamento);
            System.out.println("✅ Departamento Administración creado");
        }
    }

    private void crearAdministradorPorDefecto() {
        if (administradorRepository.count() == 0) {
            Rol adminRol = rolRepository.findByNombre("ADMIN").get();
            Departamentos departamento = departamentosRepository.findAll().get(0);

            administradorEntitie admin = new administradorEntitie();
            admin.setUsername("admin");
            admin.setEmail("admin@autotec.com");
            admin.setPasswordHash(passwordEncoder.encode("admin123"));
            admin.setRol(adminRol);
            admin.setDepartamento(departamento);
            admin.setActivo(true);

            administradorRepository.save(admin);
            System.out.println("✅ Administrador por defecto creado:");
            System.out.println("   Usuario: admin");
            System.out.println("   Email: admin@autotec.com");
            System.out.println("   Contraseña: admin123");
        }
    }

    // Opcional: También crear un usuario con rol ADMIN (en tabla usuarios)
    private void crearUsuarioAdministrador() {
        if (usuarioRepository.findByUsername("superadmin").isEmpty()) {
            Rol adminRol = rolRepository.findByNombre("ADMIN").get();
            Departamentos departamento = departamentosRepository.findAll().get(0);

            usuarioEntitie superAdmin = new usuarioEntitie();
            superAdmin.setUsername("superadmin");
            superAdmin.setEmail("superadmin@autotec.com");
            superAdmin.setPasswordHash(passwordEncoder.encode("superadmin123"));
            superAdmin.setNombres("Super");
            superAdmin.setApellidos("Administrador");
            superAdmin.setRol(adminRol);
            superAdmin.setActivo(true);

            usuarioRepository.save(superAdmin);
            System.out.println("✅ Usuario administrador creado:");
            System.out.println("   Usuario: superadmin");
            System.out.println("   Contraseña: superadmin123");
        }
    }
}