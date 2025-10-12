package com.organization.Auto_TEC.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.Auto_TEC.Entities.Sesiones;

@Repository
public interface SesionRepository extends JpaRepository<Sesiones, Long> {
    Optional<Sesiones> findFirstByUsuario_IdAndActivaTrue(Long usuarioId);
    Optional<Sesiones> findBySessionTokenAndActivaTrue(String sessionToken);
    void deleteByUsuario_IdAndActivaTrue(Long usuarioId);
}