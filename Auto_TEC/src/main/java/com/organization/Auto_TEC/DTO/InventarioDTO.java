package com.organization.Auto_TEC.DTO;

import java.time.OffsetDateTime;

public class InventarioDTO {
    private Long id;
    private Long modeloId;
    private String modeloNombre;
    private Integer cantidad;
    private String ubicacion;
    private OffsetDateTime fechaActualizacion;

    // Constructor
    public InventarioDTO() {}

    public InventarioDTO(Long id, Long modeloId, Integer cantidad, String ubicacion, OffsetDateTime fechaActualizacion) {
        this.id = id;
        this.modeloId = modeloId;
        this.cantidad = (cantidad != null) ? cantidad : 0;
        this.ubicacion = ubicacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }

    public String getModeloNombre() { return modeloNombre; }
    public void setModeloNombre(String modeloNombre) { this.modeloNombre = modeloNombre; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) {
        this.cantidad = (cantidad != null) ? cantidad : 0;
    }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public OffsetDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(OffsetDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }
}