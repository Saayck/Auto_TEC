package com.organization.Auto_TEC.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.Auto_TEC.Entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}