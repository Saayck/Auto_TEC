package com.organization.Auto_TEC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.Auto_TEC.Entities.empleadoEntitie;

public interface EmpleadoRepository extends JpaRepository<empleadoEntitie, Long> {

    List<empleadoEntitie> findByActivoTrue();
}