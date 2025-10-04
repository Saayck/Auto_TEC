package com.organization.Auto_TEC.Service;

import com.organization.Auto_TEC.Entities.pagoMetodo;
import java.util.List;
import java.util.Optional;

public interface MetodoPagoService {
    List<pagoMetodo> findAll();
    Optional<pagoMetodo> findById(Long id);
    pagoMetodo save(pagoMetodo metodoPago);
    void deleteById(Long id);
}