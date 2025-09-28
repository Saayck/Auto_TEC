package com.organization.Auto_TEC.DTO;

import java.time.LocalDateTime;

public class carritoDTO {
    private Long id;
    private String sessionId;
    private Long modeloId;
    private String modeloNombre;
    private Integer cantidad;
    private LocalDateTime fechaAgregado;

    // Constructor
    public carritoDTO() {}

    public carritoDTO(Long id, String sessionId, Long modeloId, Integer cantidad, LocalDateTime fechaAgregado) {
        this.id = id;
        this.sessionId = sessionId;
        this.modeloId = modeloId;
        this.cantidad = cantidad;
        this.fechaAgregado = fechaAgregado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }

    public String getModeloNombre() { return modeloNombre; }
    public void setModeloNombre(String modeloNombre) { this.modeloNombre = modeloNombre; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) {
        this.cantidad = (cantidad != null && cantidad > 0) ? cantidad : 0;
    }

    public LocalDateTime getFechaAgregado() { return fechaAgregado; }
    public void setFechaAgregado(LocalDateTime fechaAgregado) { this.fechaAgregado = fechaAgregado; }
}