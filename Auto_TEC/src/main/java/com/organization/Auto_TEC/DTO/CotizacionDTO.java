package com.organization.Auto_TEC.DTO;

import java.time.LocalDateTime;

import com.organization.Auto_TEC.Entities.cotizacionEstado;

// Dto principal para Cotizacion

public class CotizacionDTO {
    private Long id;
    private Long usuarioId;
    private String usuarioNombre;
    private Long modeloId;
    private String modeloNombre;
    private String nombreSolicitante;
    private String emailSolicitante;
    private String modeloInteres;
    private LocalDateTime fechaSolicitud;
    private cotizacionEstado estado;
    private String notas;

    // Constructor
    public CotizacionDTO() {}

    public CotizacionDTO(Long id, Long usuarioId, Long modeloId, String nombreSolicitante, 
                        String emailSolicitante, String modeloInteres, LocalDateTime fechaSolicitud, 
                        cotizacionEstado estado, String notas) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.modeloId = modeloId;
        this.nombreSolicitante = nombreSolicitante;
        this.emailSolicitante = emailSolicitante;
        this.modeloInteres = modeloInteres;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = (estado != null) ? estado : cotizacionEstado.PENDIENTE;
        this.notas = notas;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }

    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }

    public String getModeloNombre() { return modeloNombre; }
    public void setModeloNombre(String modeloNombre) { this.modeloNombre = modeloNombre; }

    public String getNombreSolicitante() { return nombreSolicitante; }
    public void setNombreSolicitante(String nombreSolicitante) { this.nombreSolicitante = nombreSolicitante; }

    public String getEmailSolicitante() { return emailSolicitante; }
    public void setEmailSolicitante(String emailSolicitante) { this.emailSolicitante = emailSolicitante; }

    public String getModeloInteres() { return modeloInteres; }
    public void setModeloInteres(String modeloInteres) { this.modeloInteres = modeloInteres; }

    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public cotizacionEstado getEstado() { return estado; }
    public void setEstado(cotizacionEstado estado) { 
        this.estado = (estado != null) ? estado : cotizacionEstado.PENDIENTE;
    }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}