package com.organization.Auto_TEC.DTO;

import java.time.LocalDateTime;

public class NotificacionDTO {
    private Long id;
    private Long usuarioId;
    private String mensaje;
    private boolean leida;
    private LocalDateTime fechaEnvio;

    // Constructor vacío
    public NotificacionDTO() {}

    // Constructor con todos los campos
    public NotificacionDTO(Long id, Long usuarioId, String mensaje, boolean leida, LocalDateTime fechaEnvio) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.mensaje = mensaje;
        this.leida = leida;
        this.fechaEnvio = fechaEnvio;
    }

    // Constructor desde la entidad
    public static NotificacionDTO fromEntity(com.organization.Auto_TEC.Entities.Notificaciones entity) {
        Long usuarioId = entity.getUsuario() != null ? entity.getUsuario().getId() : null;
        
        return new NotificacionDTO(
            entity.getId(),
            usuarioId,
            entity.getMensaje(),
            entity.isLeida(),
            entity.getFechaEnvio()
        );
    }

    // Constructor para creación (sin ID)
    public NotificacionDTO(Long usuarioId, String mensaje, boolean leida) {
        this.usuarioId = usuarioId;
        this.mensaje = mensaje;
        this.leida = leida;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}