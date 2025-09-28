package com.organization.Auto_TEC.DTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class VentaDTO {
    private Long id;
    private Long clienteId;
    private String clienteNombre;
    private Long modeloId;
    private String modeloNombre;
    private String modeloMarca;
    private Long vendedorId;
    private String vendedorNombre;
    private OffsetDateTime fechaVenta;
    private BigDecimal precioVenta;
    private String estado;
    private Long metodoPagoId;
    private String metodoPagoNombre;
    private BigDecimal comisionVendedor;
    private String notas;

    // Constructor vacío
    public VentaDTO() {}

    // Constructor con todos los campos
    public VentaDTO(Long id, Long clienteId, String clienteNombre, Long modeloId, String modeloNombre, 
                   String modeloMarca, Long vendedorId, String vendedorNombre, OffsetDateTime fechaVenta, 
                   BigDecimal precioVenta, String estado, Long metodoPagoId, String metodoPagoNombre, 
                   BigDecimal comisionVendedor, String notas) {
        this.id = id;
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.modeloId = modeloId;
        this.modeloNombre = modeloNombre;
        this.modeloMarca = modeloMarca;
        this.vendedorId = vendedorId;
        this.vendedorNombre = vendedorNombre;
        this.fechaVenta = fechaVenta;
        this.precioVenta = precioVenta;
        this.estado = estado;
        this.metodoPagoId = metodoPagoId;
        this.metodoPagoNombre = metodoPagoNombre;
        this.comisionVendedor = comisionVendedor;
        this.notas = notas;
    }

    // Constructor desde la entidad
    public static VentaDTO fromEntity(com.organization.Auto_TEC.Entities.ventasEntitie entity) {
        Long clienteId = entity.getCliente() != null ? entity.getCliente().getId() : null;
        String clienteNombre = entity.getCliente() != null ? 
            entity.getCliente().getNombres() + " " + entity.getCliente().getApellidos() : null;
        
        Long modeloId = entity.getModelo() != null ? entity.getModelo().getId() : null;
        String modeloNombre = entity.getModelo() != null ? entity.getModelo().getNombre() : null;
        String modeloMarca = entity.getModelo() != null ? entity.getModelo().getMarca() : null;
        
        Long vendedorId = entity.getVendedor() != null ? entity.getVendedor().getId() : null;
        String vendedorNombre = entity.getVendedor() != null ? 
            entity.getVendedor().getNombres() + " " + entity.getVendedor().getApellidos() : null;
        
        Long metodoPagoId = entity.getMetodo_pago() != null ? entity.getMetodo_pago().getId() : null;
        String metodoPagoNombre = entity.getMetodo_pago() != null ? entity.getMetodo_pago().getNombre() : null;
        
        String estado = entity.getEstado() != null ? entity.getEstado().name() : null;

        return new VentaDTO(
            entity.getId(),
            clienteId,
            clienteNombre,
            modeloId,
            modeloNombre,
            modeloMarca,
            vendedorId,
            vendedorNombre,
            entity.getFechaVenta(),
            entity.getPrecioVenta(),
            estado,
            metodoPagoId,
            metodoPagoNombre,
            entity.getComisionVendedor(),
            entity.getNotas()
        );
    }

    // Constructor para creación (sin ID ni fecha)
    public VentaDTO(Long clienteId, Long modeloId, Long vendedorId, BigDecimal precioVenta, 
                   String estado, Long metodoPagoId, BigDecimal comisionVendedor, String notas) {
        this.clienteId = clienteId;
        this.modeloId = modeloId;
        this.vendedorId = vendedorId;
        this.precioVenta = precioVenta;
        this.estado = estado;
        this.metodoPagoId = metodoPagoId;
        this.comisionVendedor = comisionVendedor;
        this.notas = notas;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }

    public String getModeloNombre() {
        return modeloNombre;
    }

    public void setModeloNombre(String modeloNombre) {
        this.modeloNombre = modeloNombre;
    }

    public String getModeloMarca() {
        return modeloMarca;
    }

    public void setModeloMarca(String modeloMarca) {
        this.modeloMarca = modeloMarca;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getVendedorNombre() {
        return vendedorNombre;
    }

    public void setVendedorNombre(String vendedorNombre) {
        this.vendedorNombre = vendedorNombre;
    }

    public OffsetDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(OffsetDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getMetodoPagoId() {
        return metodoPagoId;
    }

    public void setMetodoPagoId(Long metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
    }

    public String getMetodoPagoNombre() {
        return metodoPagoNombre;
    }

    public void setMetodoPagoNombre(String metodoPagoNombre) {
        this.metodoPagoNombre = metodoPagoNombre;
    }

    public BigDecimal getComisionVendedor() {
        return comisionVendedor;
    }

    public void setComisionVendedor(BigDecimal comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}