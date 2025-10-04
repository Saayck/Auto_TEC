package com.organization.Auto_TEC.Service;

import com.organization.Auto_TEC.Entities.empleadoEntitie;
import com.organization.Auto_TEC.Repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<empleadoEntitie> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<empleadoEntitie> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public empleadoEntitie save(empleadoEntitie empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public List<empleadoEntitie> findByActivoTrue() {
        return empleadoRepository.findByActivoTrue();
    }
}