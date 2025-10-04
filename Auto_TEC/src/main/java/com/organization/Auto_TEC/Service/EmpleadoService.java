package com.organization.Auto_TEC.Service;

import java.util.List;
import java.util.Optional;

import com.organization.Auto_TEC.Entities.empleadoEntitie;

public interface EmpleadoService {
    List<empleadoEntitie> findAll();
    Optional<empleadoEntitie> findById(Long id);
    empleadoEntitie save(empleadoEntitie empleado);
    void deleteById(Long id);
    List<empleadoEntitie> findByActivoTrue();
}