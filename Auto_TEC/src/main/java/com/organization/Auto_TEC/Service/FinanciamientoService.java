package com.organization.Auto_TEC.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.Auto_TEC.DTO.FinanciamientoPlanDTO;
import com.organization.Auto_TEC.DTO.FinanciamientoPlanRequestDTO;

@Service
public interface FinanciamientoService {
    List<FinanciamientoPlanDTO> getAll();
    FinanciamientoPlanDTO getById(Long id);
    FinanciamientoPlanDTO save(FinanciamientoPlanRequestDTO financiamiento);
    FinanciamientoPlanDTO update(Long id, FinanciamientoPlanRequestDTO financiamiento);
    void delete(Long id);
}