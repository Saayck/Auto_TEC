package com.organization.Auto_TEC.Service;

import java.util.List;
import java.util.Optional;

import com.organization.Auto_TEC.Entities.modelosEntitie;

public interface ModeloService {
    List<modelosEntitie> findAll();
    Optional<modelosEntitie> findById(Long id);
    modelosEntitie save(modelosEntitie modelo);
    void deleteById(Long id);
    List<modelosEntitie> findByMarca(String marca);
    List<modelosEntitie> findDestacados();
    List<modelosEntitie> findByActivoTrue();
}