package com.organization.Auto_TEC.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// DTOs para financiamientoCalculo (Cálculos de Financiamiento)

public class FinanciamientoCalculoDTO {
    private Long id;
    private Long usuarioId;
    private String usuarioNombre;
    private String modeloVehiculo;
    private BigDecimal precioVehiculo;
    private BigDecimal cuotaInicial;
    private Integer plazoMeses;
    private BigDecimal tasaInteres;
    private BigDecimal cuotaMensual;
    private BigDecimal totalFinanciado;
    private LocalDateTime fechaCalculo;

    // Constructor
    public FinanciamientoCalculoDTO() {}

    public FinanciamientoCalculoDTO(Long id, Long usuarioId, String modeloVehiculo, 
                                   BigDecimal precioVehiculo, BigDecimal cuotaInicial, 
                                   Integer plazoMeses, BigDecimal tasaInteres, 
                                   BigDecimal cuotaMensual, BigDecimal totalFinanciado, 
                                   LocalDateTime fechaCalculo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.modeloVehiculo = modeloVehiculo;
        this.precioVehiculo = precioVehiculo;
        this.cuotaInicial = cuotaInicial;
        this.plazoMeses = plazoMeses;
        this.tasaInteres = tasaInteres;
        this.cuotaMensual = cuotaMensual;
        this.totalFinanciado = totalFinanciado;
        this.fechaCalculo = fechaCalculo;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }

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

    public BigDecimal getCuotaMensual() { return cuotaMensual; }
    public void setCuotaMensual(BigDecimal cuotaMensual) { this.cuotaMensual = cuotaMensual; }

    public BigDecimal getTotalFinanciado() { return totalFinanciado; }
    public void setTotalFinanciado(BigDecimal totalFinanciado) { this.totalFinanciado = totalFinanciado; }

    public LocalDateTime getFechaCalculo() { return fechaCalculo; }
    public void setFechaCalculo(LocalDateTime fechaCalculo) { this.fechaCalculo = fechaCalculo; }
}