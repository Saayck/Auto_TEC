package com.organization.Auto_TEC.DTO;

import java.time.OffsetDateTime;

public class AdministradorDTO {
    private Long id;
    private Long rolId;
    private String rolNombre;
    private Long departamentoId;
    private String departamentoNombre;
    private String username;
    private String email;
    private OffsetDateTime fechaCreacion;
    private Boolean activo;

    // Constructores
    public AdministradorDTO() {}

    public AdministradorDTO(Long id, Long rolId, Long departamentoId, 
                           String username, String email, 
                           OffsetDateTime fechaCreacion, Boolean activo) {
        this.id = id;
        this.rolId = rolId;
        this.departamentoId = departamentoId;
        this.username = username;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public AdministradorDTO(Long id, Long rolId, String rolNombre, 
                           Long departamentoId, String departamentoNombre,
                           String username, String email, 
                           OffsetDateTime fechaCreacion, Boolean activo) {
        this.id = id;
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.departamentoId = departamentoId;
        this.departamentoNombre = departamentoNombre;
        this.username = username;
        this.email = email;
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

    public String getUsername() { return username; } // ✅ Nuevo getter
    public void setUsername(String username) { this.username = username; } // ✅ Nuevo setter

    public String getEmail() { return email; } // ✅ Nuevo getter
    public void setEmail(String email) { this.email = email; } // ✅ Nuevo setter

    public OffsetDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(OffsetDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "AdministradorDTO{" +
                "id=" + id +
                ", rolId=" + rolId +
                ", rolNombre='" + rolNombre + '\'' +
                ", departamentoId=" + departamentoId +
                ", departamentoNombre='" + departamentoNombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", activo=" + activo +
                '}';
    }
}