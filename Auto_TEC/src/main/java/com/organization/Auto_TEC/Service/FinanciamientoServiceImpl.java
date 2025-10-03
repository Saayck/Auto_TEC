package com.organization.Auto_TEC.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.organization.Auto_TEC.DTO.FinanciamientoPlanDTO;
import com.organization.Auto_TEC.DTO.FinanciamientoPlanRequestDTO;

@Service
public class FinanciamientoServiceImpl implements FinanciamientoService {

    private final List<FinanciamientoPlanDTO> lista = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<FinanciamientoPlanDTO> getAll() {
        return new ArrayList<>(lista); // Retorna copia para evitar modificación externa
    }

    @Override
    public FinanciamientoPlanDTO getById(Long id) {
        if (id == null) return null;
        return lista.stream()
                .filter(f -> f.getId() != null && f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public FinanciamientoPlanDTO save(FinanciamientoPlanRequestDTO financiamientoRequest) {
        if (financiamientoRequest == null) return null;
        
        FinanciamientoPlanDTO nuevoFinanciamiento = new FinanciamientoPlanDTO();
        nuevoFinanciamiento.setId(idCounter++);
        nuevoFinanciamiento.setNombre(financiamientoRequest.getNombre());
        nuevoFinanciamiento.setDescripcion(financiamientoRequest.getDescripcion());
        nuevoFinanciamiento.setTasaInteres(financiamientoRequest.getTasaInteres());
        nuevoFinanciamiento.setPlazoMin(financiamientoRequest.getPlazoMin());
        nuevoFinanciamiento.setPlazoMax(financiamientoRequest.getPlazoMax());
        nuevoFinanciamiento.setEngancheMinimo(financiamientoRequest.getEngancheMinimo());
        nuevoFinanciamiento.setRequisitos(financiamientoRequest.getRequisitos());
        nuevoFinanciamiento.setActivo(financiamientoRequest.isActivo());
        
        lista.add(nuevoFinanciamiento);
        return nuevoFinanciamiento;
    }

    @Override
    public FinanciamientoPlanDTO update(Long id, FinanciamientoPlanRequestDTO financiamientoRequest) {
        if (id == null || financiamientoRequest == null) return null;
        
        for (int i = 0; i < lista.size(); i++) {
            FinanciamientoPlanDTO financiamientoExistente = lista.get(i);
            if (Objects.equals(financiamientoExistente.getId(), id)) {
                // Actualizar el financiamiento existente
                financiamientoExistente.setNombre(financiamientoRequest.getNombre());
                financiamientoExistente.setDescripcion(financiamientoRequest.getDescripcion());
                financiamientoExistente.setTasaInteres(financiamientoRequest.getTasaInteres());
                financiamientoExistente.setPlazoMin(financiamientoRequest.getPlazoMin());
                financiamientoExistente.setPlazoMax(financiamientoRequest.getPlazoMax());
                financiamientoExistente.setEngancheMinimo(financiamientoRequest.getEngancheMinimo());
                financiamientoExistente.setRequisitos(financiamientoRequest.getRequisitos());
                financiamientoExistente.setActivo(financiamientoRequest.isActivo());
                
                lista.set(i, financiamientoExistente);
                return financiamientoExistente;
            }
        }
        return null; // No se encontró el financiamiento a actualizar
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            lista.removeIf(f -> Objects.equals(f.getId(), id));
        }
    }
}