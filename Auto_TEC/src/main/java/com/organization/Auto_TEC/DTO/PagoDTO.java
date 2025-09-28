package com.organization.Auto_TEC.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoDTO {
    private Long id;
    private Long ventaId;
    private Long metodoPagoId;
    private String metodoPagoNombre;
    private BigDecimal monto;
    private LocalDateTime fechaPago;
    private String estadoPago;

    // Constructor vacío
    public PagoDTO() {}

    // Constructor con todos los campos
    public PagoDTO(Long id, Long ventaId, Long metodoPagoId, String metodoPagoNombre, 
                  BigDecimal monto, LocalDateTime fechaPago, String estadoPago) {
        this.id = id;
        this.ventaId = ventaId;
        this.metodoPagoId = metodoPagoId;
        this.metodoPagoNombre = metodoPagoNombre;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.estadoPago = estadoPago;
    }

    // Constructor desde la entidad
    public static PagoDTO fromEntity(com.organization.Auto_TEC.Entities.pagoEntitie entity) {
        Long ventaId = entity.getVenta() != null ? entity.getVenta().getId() : null;
        Long metodoPagoId = entity.getMetodoPago() != null ? entity.getMetodoPago().getId() : null;
        String metodoPagoNombre = entity.getMetodoPago() != null ? entity.getMetodoPago().getNombre() : null;
        String estadoPago = entity.getEstadoPago() != null ? entity.getEstadoPago().name() : null;

        return new PagoDTO(
            entity.getId(),
            ventaId,
            metodoPagoId,
            metodoPagoNombre,
            entity.getMonto(),
            entity.getFechaPago(),
            estadoPago
        );
    }

    // Constructor para creación (sin ID ni fecha)
    public PagoDTO(Long ventaId, Long metodoPagoId, BigDecimal monto, String estadoPago) {
        this.ventaId = ventaId;
        this.metodoPagoId = metodoPagoId;
        this.monto = monto;
        this.estadoPago = estadoPago;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVentaId() {
        return ventaId;
    }

    public void setVentaId(Long ventaId) {
        this.ventaId = ventaId;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}