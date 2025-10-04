package com.organization.Auto_TEC.Service;

import com.organization.Auto_TEC.DTO.VentaDTO;
import com.organization.Auto_TEC.Entities.ventasEntitie;
import com.organization.Auto_TEC.Entities.ventaEstado;
import com.organization.Auto_TEC.Repository.VentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final UsuarioService usuarioService;
    private final ModeloService modeloService;
    private final EmpleadoService empleadoService;
    private final MetodoPagoService metodoPagoService;

    public VentaServiceImpl(VentaRepository ventaRepository, UsuarioService usuarioService,
                           ModeloService modeloService, EmpleadoService empleadoService,
                           MetodoPagoService metodoPagoService) {
        this.ventaRepository = ventaRepository;
        this.usuarioService = usuarioService;
        this.modeloService = modeloService;
        this.empleadoService = empleadoService;
        this.metodoPagoService = metodoPagoService;
    }

    @Override
    public VentaDTO guardarVenta(VentaDTO ventaDTO) {
        ventasEntitie venta = new ventasEntitie();
        
        // Mapear DTO a Entidad según tus entities
        venta.setCliente(usuarioService.findById(ventaDTO.getClienteId()).orElse(null));
        venta.setModelo(modeloService.findById(ventaDTO.getModeloId()).orElse(null));
        venta.setVendedor(usuarioService.findById(ventaDTO.getVendedorId()).orElse(null));
        venta.setMetodoPago(metodoPagoService.findById(ventaDTO.getMetodoPagoId()).orElse(null));
        venta.setPrecioVenta(ventaDTO.getPrecioVenta());
        venta.setComisionVendedor(ventaDTO.getComisionVendedor());
        venta.setNotas(ventaDTO.getNotas());
        
        // Establecer estado según tu enum
        if (ventaDTO.getEstado() != null) {
            try {
                venta.setEstado(ventaEstado.valueOf(ventaDTO.getEstado()));
            } catch (IllegalArgumentException e) {
                venta.setEstado(ventaEstado.RESERVADO); // Valor por defecto
            }
        } else {
            venta.setEstado(ventaEstado.RESERVADO); // Valor por defecto según tu BD
        }
        
        ventasEntitie ventaGuardada = ventaRepository.save(venta);
        return VentaDTO.fromEntity(ventaGuardada);
    }

    @Override
    public List<VentaDTO> findAll() {
        return ventaRepository.findAll()
                .stream()
                .map(VentaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public VentaDTO findById(Long id) {
        return ventaRepository.findById(id)
                .map(VentaDTO::fromEntity)
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public List<VentaDTO> findByEstado(String estado) {
        try {
            ventaEstado estadoEnum = ventaEstado.valueOf(estado);
            return ventaRepository.findByEstado(estadoEnum)
                    .stream()
                    .map(VentaDTO::fromEntity)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            return List.of();
        }
    }
}