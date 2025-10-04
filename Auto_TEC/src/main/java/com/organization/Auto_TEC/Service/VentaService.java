package com.organization.Auto_TEC.Service;

import com.organization.Auto_TEC.DTO.VentaDTO;
import java.util.List;

public interface VentaService {
    VentaDTO guardarVenta(VentaDTO ventaDTO);
    List<VentaDTO> findAll();
    VentaDTO findById(Long id);
    void deleteById(Long id);
    List<VentaDTO> findByEstado(String estado);
}