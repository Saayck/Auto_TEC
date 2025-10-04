package com.organization.Auto_TEC.Service;

import com.organization.Auto_TEC.Entities.pagoMetodo;
import com.organization.Auto_TEC.Repository.MetodoPagoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoServiceImpl(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    @Override
    public List<pagoMetodo> findAll() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public Optional<pagoMetodo> findById(Long id) {
        return metodoPagoRepository.findById(id);
    }

    @Override
    public pagoMetodo save(pagoMetodo metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    public void deleteById(Long id) {
        metodoPagoRepository.deleteById(id);
    }
}