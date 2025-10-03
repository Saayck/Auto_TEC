package com.organization.Auto_TEC.Service;

import java.util.Set;
import org.springframework.security.core.userdetails.*;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.organization.Auto_TEC.Repository.AdministradorRepository;
import com.organization.Auto_TEC.Entities.administradorEntitie;
import com.organization.Auto_TEC.Entities.Rol;
@Primary
@Service("adminUserDetailsService")
public class AdminUserDetailsService implements UserDetailsService {

  private final AdministradorRepository adminRepo;

  public AdminUserDetailsService(AdministradorRepository adminRepo) {
    this.adminRepo = adminRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    administradorEntitie a = adminRepo
        .findByUsernameOrEmail(login, login)
        .orElseThrow(() -> new UsernameNotFoundException("Administrador no encontrado"));

    Rol rol = a.getRol();
    String nombreRol = (rol != null && rol.getNombre() != null) ? rol.getNombre() : "ADMIN";
    String authority = nombreRol.startsWith("ROLE_") ? nombreRol : "ROLE_" + nombreRol;

    return User
        .withUsername(a.getEmail())
        .password(a.getPasswordHash()) 
        .authorities(Set.of(new SimpleGrantedAuthority(authority)))
        .accountExpired(false).accountLocked(false)
        .credentialsExpired(false).disabled(false)
        .build();
  }
}
