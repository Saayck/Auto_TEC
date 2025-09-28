package com.organization.Auto_TEC.DTO;

import java.time.OffsetDateTime;

// DTO para respuesta de login (funciona con SesionDTO)

public class LoginResponseDTO {
    private String sessionToken;
    private OffsetDateTime fechaExpiracion;
    private Long usuarioId;
    private String mensaje;

    // Constructores
    public LoginResponseDTO() {}

    public LoginResponseDTO(String sessionToken, OffsetDateTime fechaExpiracion, Long usuarioId, String mensaje) {
        this.sessionToken = sessionToken;
        this.fechaExpiracion = fechaExpiracion;
        this.usuarioId = usuarioId;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public OffsetDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(OffsetDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
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
}