package com.organization.Auto_TEC.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.Auto_TEC.Entities.usuarioEntitie;

public interface UsuarioRepository extends JpaRepository<usuarioEntitie, Long> {
  Optional<usuarioEntitie> findByUsername(String username);
  Optional<usuarioEntitie> findByEmail(String email);
  Optional<usuarioEntitie> findByUsernameOrEmail(String username, String email);
}
