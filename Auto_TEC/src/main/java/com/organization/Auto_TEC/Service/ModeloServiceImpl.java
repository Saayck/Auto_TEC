package com.organization.Auto_TEC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.organization.Auto_TEC.Entities.modelosEntitie;
import com.organization.Auto_TEC.Repository.ModeloRepository;

@Service
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository modeloRepository;

    public ModeloServiceImpl(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @Override
    public List<modelosEntitie> findAll() {
        return modeloRepository.findAll();
    }

    @Override
    public Optional<modelosEntitie> findById(Long id) {
        return modeloRepository.findById(id);
    }

    @Override
    public modelosEntitie save(modelosEntitie modelo) {
        return modeloRepository.save(modelo);
    }

    @Override
    public void deleteById(Long id) {
        modeloRepository.deleteById(id);
    }

    @Override
    public List<modelosEntitie> findByMarca(String marca) {
        return modeloRepository.findByMarcaContainingIgnoreCase(marca);
    }

    @Override
    public List<modelosEntitie> findDestacados() {
        return modeloRepository.findByDestacadoTrue();
    }

    @Override
    public List<modelosEntitie> findByActivoTrue() {
        return modeloRepository.findByActivoTrue();
    }
}