package com.organization.Auto_TEC.DTO;

import java.time.LocalDateTime;

// Dto princiapl para Historial de Actividad

public class HistorialActividadDTO {
    private Long id;
    private Long usuarioId;
    private String usuarioNombre;
    private String accion;
    private String descripcion;
    private LocalDateTime fecha;

    // Constructor
    public HistorialActividadDTO() {}

    public HistorialActividadDTO(Long id, Long usuarioId, String accion, 
                                String descripcion, LocalDateTime fecha) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.accion = accion;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}