package com.organization.Auto_TEC.DTO;

import java.time.OffsetDateTime;

public class SesionDTO {
    private Long id;
    private Long usuarioId;
    private String sessionToken; // ✅ Cambiado de "token" a "sessionToken" para coincidir
    private OffsetDateTime fechaCreacion;
    private OffsetDateTime fechaExpiracion;
    private boolean activa;
    private String ipAddress;
    private String userAgent;

    // Constructor vacío
    public SesionDTO() {}

    // Constructor con todos los campos
    public SesionDTO(Long id, Long usuarioId, String sessionToken, OffsetDateTime fechaCreacion,
                    OffsetDateTime fechaExpiracion, boolean activa, String ipAddress, String userAgent) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.sessionToken = sessionToken;
        this.fechaCreacion = fechaCreacion;
        this.fechaExpiracion = fechaExpiracion;
        this.activa = activa;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
    }

    // Constructor desde la entidad
    public static SesionDTO fromEntity(com.organization.Auto_TEC.Entities.Sesiones entity) {
        if (entity == null) {
            return null;
        }
        
        Long usuarioId = entity.getUsuario() != null ? entity.getUsuario().getId() : null;
        
        return new SesionDTO(
            entity.getId(),
            usuarioId,
            entity.getSessionToken(),
            entity.getFechaCreacion(),
            entity.getFechaExpiracion(),
            entity.getActiva() != null ? entity.getActiva() : false, 
            entity.getIpAddress(),
            entity.getUserAgent()
        );
    }

    // Constructor para creación (sin ID ni fechaCreacion)
    public SesionDTO(Long usuarioId, String sessionToken, OffsetDateTime fechaExpiracion,
                    boolean activa, String ipAddress, String userAgent) {
        this.usuarioId = usuarioId;
        this.sessionToken = sessionToken;
        this.fechaExpiracion = fechaExpiracion;
        this.activa = activa;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
    }

    // Constructor simplificado para login
    public SesionDTO(Long usuarioId, String sessionToken, OffsetDateTime fechaExpiracion) {
        this.usuarioId = usuarioId;
        this.sessionToken = sessionToken;
        this.fechaExpiracion = fechaExpiracion;
        this.activa = true;
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

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public OffsetDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(OffsetDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public OffsetDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(OffsetDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    // Método para verificar si la sesión está expirada
    public boolean isExpirada() {
        return fechaExpiracion != null && OffsetDateTime.now().isAfter(fechaExpiracion);
    }

    // Método para verificar si la sesión es válida (activa y no expirada)
    public boolean isValida() {
        return activa && !isExpirada();
    }
}