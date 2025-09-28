package com.organization.Auto_TEC.DTO;

import java.math.BigDecimal;

// DTO para Solicitud de Cálculo de Financiamiento funciona con FinanciamientoCalculoDTO

public class FinanciamientoCalculoRequestDTO {
    private Long usuarioId;
    private String modeloVehiculo;
    private BigDecimal precioVehiculo;
    private BigDecimal cuotaInicial;
    private Integer plazoMeses;
    private BigDecimal tasaInteres;

    // Constructores
    public FinanciamientoCalculoRequestDTO() {}

    // Getters y Setters
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getModeloVehiculo() { return modeloVehiculo; }
    public void setModeloVehiculo(String modeloVehiculo) { this.modeloVehiculo = modeloVehiculo; }

    public BigDecimal getPrecioVehiculo() { return precioVehiculo; }
    public void setPrecioVehiculo(BigDecimal precioVehiculo) { this.precioVehiculo = precioVehiculo; }

    public BigDecimal getCuotaInicial() { return cuotaInicial; }
    public void setCuotaInicial(BigDecimal cuotaInicial) { this.cuotaInicial = cuotaInicial; }

    public Integer getPlazoMeses() { return plazoMeses; }
    public void setPlazoMeses(Integer plazoMeses) { this.plazoMeses = plazoMeses; }

    public BigDecimal getTasaInteres() { return tasaInteres; }
    public void setTasaInteres(BigDecimal tasaInteres) { this.tasaInteres = tasaInteres; }
}