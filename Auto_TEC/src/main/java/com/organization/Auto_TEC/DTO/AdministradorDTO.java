package com.organization.Auto_TEC.DTO;

import java.time.OffsetDateTime;

public class AdministradorDTO {
    private Long id;
    private Long rolId;
    private String rolNombre;
    private Long departamentoId;
    private String departamentoNombre;
    private OffsetDateTime fechaCreacion;
    private Boolean activo;

    // Constructor
    public AdministradorDTO() {}

    public AdministradorDTO(Long id, Long rolId, Long departamentoId, OffsetDateTime fechaCreacion, Boolean activo) {
        this.id = id;
        this.rolId = rolId;
        this.departamentoId = departamentoId;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }

    public String getRolNombre() { return rolNombre; }
    public void setRolNombre(String rolNombre) { this.rolNombre = rolNombre; }

    public Long getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(Long departamentoId) { this.departamentoId = departamentoId; }

    public String getDepartamentoNombre() { return departamentoNombre; }
    public void setDepartamentoNombre(String departamentoNombre) { this.departamentoNombre = departamentoNombre; }

    public OffsetDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(OffsetDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}