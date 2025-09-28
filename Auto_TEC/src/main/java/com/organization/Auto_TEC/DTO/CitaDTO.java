package com.organization.Auto_TEC.DTO;

import java.time.LocalDateTime;

import com.organization.Auto_TEC.Entities.citaEstado;
import com.organization.Auto_TEC.Entities.citaTipo;

public class CitaDTO {
    private Long id;
    private Long usuarioId;
    private String usuarioNombre;
    private Long empleadoId;
    private String empleadoNombre;
    private citaTipo tipoCita;
    private LocalDateTime fechaCita;
    private Integer duracionEstimada;
    private citaEstado estado;
    private String notas;
    private LocalDateTime fechaCreacion;

    // Constructores
    public CitaDTO() {}

    public CitaDTO(Long id, Long usuarioId, Long empleadoId, citaTipo tipoCita, 
                  LocalDateTime fechaCita, Integer duracionEstimada, citaEstado estado, 
                  String notas, LocalDateTime fechaCreacion) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.empleadoId = empleadoId;
        this.tipoCita = tipoCita;
        this.fechaCita = fechaCita;
        this.duracionEstimada = duracionEstimada;
        this.estado = estado;
        this.notas = notas;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }

    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }

    public String getEmpleadoNombre() { return empleadoNombre; }
    public void setEmpleadoNombre(String empleadoNombre) { this.empleadoNombre = empleadoNombre; }

    public citaTipo getTipoCita() { return tipoCita; }
    public void setTipoCita(citaTipo tipoCita) { this.tipoCita = tipoCita; }

    public LocalDateTime getFechaCita() { return fechaCita; }
    public void setFechaCita(LocalDateTime fechaCita) { this.fechaCita = fechaCita; }

    public Integer getDuracionEstimada() { return duracionEstimada; }
    public void setDuracionEstimada(Integer duracionEstimada) {
        this.duracionEstimada = (duracionEstimada != null) ? duracionEstimada : 60;
    }

    public citaEstado getEstado() { return estado; }
    public void setEstado(citaEstado estado) { this.estado = estado; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}