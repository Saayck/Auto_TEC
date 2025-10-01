package com.organization.Auto_TEC.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.Auto_TEC.Entities.Sesiones;

public interface SesionRepository extends JpaRepository<Sesiones, Long> {
    Optional<Sesiones> findFirstByUsuario_IdAndActivaTrue(Long id);
    Optional<Sesiones> findByTokenAndActivaTrue(String token);
}
