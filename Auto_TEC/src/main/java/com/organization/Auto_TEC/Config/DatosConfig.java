package com.organization.Auto_TEC.Config;

import java.time.OffsetDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.organization.Auto_TEC.Entities.Rol;
import com.organization.Auto_TEC.Entities.usuarioEntitie;
import com.organization.Auto_TEC.Repository.RolRepository;
import com.organization.Auto_TEC.Repository.UsuarioRepository;

public class DatosConfig {
    
    @Bean
  CommandLineRunner seedAdmin(UsuarioRepository usuarioRepo,
                              RolRepository rolRepo,
                              PasswordEncoder encoder) {
    return args -> {
      Rol adminRol = rolRepo.findByNombre("ADMIN")
          .orElseGet(() -> {
            Rol r = new Rol();
            r.setNombre("ADMIN"); 
            return rolRepo.save(r);
          });

      // 2) Usuario admin
      usuarioRepo.findByEmail("admin.ica@empresa.com").orElseGet(() -> {
        usuarioEntitie u = new usuarioEntitie();
        u.setUsername("admin");                        // opcional
        u.setEmail("admin.ica@empresa.com");
        u.setPasswordHash(encoder.encode("admin123"));
        u.setRol(adminRol);                            // si tu usuario tiene UN rol
        u.setUltimoLogin(OffsetDateTime.now());        // opcional, si existe
        return usuarioRepo.save(u);
      });
    };
  }
}
