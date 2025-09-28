package com.organization.Auto_TEC.DTO;

import java.time.LocalDateTime;

public class FavoritoDTO {
    private Long id;
    private String sessionId;
    private Long modeloId;
    private String modeloNombre;
    private String marcaNombre;
    private LocalDateTime fechaAgregado;

    // Constructor
    public FavoritoDTO() {}

    public FavoritoDTO(Long id, String sessionId, Long modeloId, LocalDateTime fechaAgregado) {
        this.id = id;
        this.sessionId = sessionId;
        this.modeloId = modeloId;
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

    public String getMarcaNombre() { return marcaNombre; }
    public void setMarcaNombre(String marcaNombre) { this.marcaNombre = marcaNombre; }

    public LocalDateTime getFechaAgregado() { return fechaAgregado; }
    public void setFechaAgregado(LocalDateTime fechaAgregado) { this.fechaAgregado = fechaAgregado; }
}