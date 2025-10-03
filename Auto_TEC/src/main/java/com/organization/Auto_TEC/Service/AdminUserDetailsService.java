package com.organization.Auto_TEC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.Auto_TEC.Entities.administradorEntitie;
import com.organization.Auto_TEC.Repository.AdministradorRepository;

@Service("adminUserDetailsService")
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private AdministradorRepository adminRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuario: " + username);
        
        // Buscar por email o username
        administradorEntitie admin = adminRepository.findByEmail(username)
                .orElseGet(() -> adminRepository.findByUsername(username)
                        .orElseThrow(() -> {
                            System.out.println("Usuario no encontrado: " + username);
                            return new UsernameNotFoundException("Usuario no encontrado: " + username);
                        }));

        System.out.println("Usuario encontrado: " + admin.getEmail());
        System.out.println("Rol: " + (admin.getRol() != null ? admin.getRol().getNombre() : "NULL"));
        System.out.println("Activo: " + admin.getActivo());

        if (!admin.getActivo()) {
            throw new UsernameNotFoundException("Usuario desactivado: " + username);
        }

        if (admin.getRol() == null) {
            throw new UsernameNotFoundException("Rol no asignado para: " + username);
        }

        String role = "ROLE_" + admin.getRol().getNombre();
        System.out.println("Authority: " + role);

        return User.builder()
                .username(admin.getEmail())
                .password(admin.getPasswordHash())
                .authorities(new SimpleGrantedAuthority(role))
                .disabled(!admin.getActivo())
                .build();
    }
}