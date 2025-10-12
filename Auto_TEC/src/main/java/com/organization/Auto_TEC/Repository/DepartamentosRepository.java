package com.organization.Auto_TEC.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.Auto_TEC.Entities.Departamentos;

@Repository
public interface DepartamentosRepository extends JpaRepository<Departamentos, Long> {
    Optional<Departamentos> findByNombre(String nombre);
}