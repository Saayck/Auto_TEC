package com.organization.Auto_TEC.Service;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.organization.Auto_TEC.Entities.Rol;
import com.organization.Auto_TEC.Entities.usuarioEntitie;
import com.organization.Auto_TEC.Repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UsuarioRepository usuarioRepo;

  public CustomUserDetailsService(UsuarioRepository usuarioRepo) {
    this.usuarioRepo = usuarioRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
    usuarioEntitie u = usuarioRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
  
    Rol rol = u.getRol();
      if (rol == null || rol.getNombre() == null || rol.getNombre().isBlank()) {
      throw new UsernameNotFoundException("Usuario sin rol asignado");
    }
    String name = rol.getNombre();
    String authority = name.startsWith("ROLE_") ? name : "ROLE_" + name;
    Collection<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority(authority));

    return User
      .withUsername(u.getUsername())// o u.getEmail()
      .password(u.getPasswordHash())      
      .authorities(authorities)
      .accountLocked(false)
      .accountExpired(false)
      .credentialsExpired(false)
      .disabled(false)
      .build();
  }
}

