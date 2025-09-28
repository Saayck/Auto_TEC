package com.organization.Auto_TEC.DTO;

import java.time.OffsetDateTime;
import java.util.Map;

public class LogAdministrativoDTO {
    private Long id;
    private Long administradorId;
    private String administradorNombre;
    private String accion;
    private String tablaAfectada;
    private Long registroId;
    private Map<String, Object> detalles;
    private OffsetDateTime fechaAccion;

    // Constructor
    public LogAdministrativoDTO() {}

    public LogAdministrativoDTO(Long id, Long administradorId, String accion, 
                               String tablaAfectada, Long registroId, 
                               Map<String, Object> detalles, OffsetDateTime fechaAccion) {
        this.id = id;
        this.administradorId = administradorId;
        this.accion = accion;
        this.tablaAfectada = tablaAfectada;
        this.registroId = registroId;
        this.detalles = detalles;
        this.fechaAccion = fechaAccion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAdministradorId() { return administradorId; }
    public void setAdministradorId(Long administradorId) { this.administradorId = administradorId; }

    public String getAdministradorNombre() { return administradorNombre; }
    public void setAdministradorNombre(String administradorNombre) { this.administradorNombre = administradorNombre; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public String getTablaAfectada() { return tablaAfectada; }
    public void setTablaAfectada(String tablaAfectada) { this.tablaAfectada = tablaAfectada; }

    public Long getRegistroId() { return registroId; }
    public void setRegistroId(Long registroId) { this.registroId = registroId; }

    public Map<String, Object> getDetalles() { return detalles; }
    public void setDetalles(Map<String, Object> detalles) { this.detalles = detalles; }

    public OffsetDateTime getFechaAccion() { return fechaAccion; }
    public void setFechaAccion(OffsetDateTime fechaAccion) { this.fechaAccion = fechaAccion; }
}