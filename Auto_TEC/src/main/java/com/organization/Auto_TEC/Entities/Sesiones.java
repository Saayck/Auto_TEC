package com.organization.Auto_TEC.Entities;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "sesiones")
public class Sesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private usuarioEntitie usuario;

    @Column(name = "token", nullable = false, length = 64, unique = true) // <-- CLAVE
    private String token;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private OffsetDateTime fechaCreacion;

    @Column(name = "fecha_expiracion", nullable = false)
    private OffsetDateTime fechaExpiracion;

    @Column(nullable = false)
    private boolean activa = true;

    @Column(name = "ip_address", length = 45)
    private String ipAddress;

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;

    public Sesiones() {}

    public Sesiones(usuarioEntitie usuario,
                  String token,
                  OffsetDateTime fechaExpiracion,
                  boolean activa,
                  String ipAddress,
                  String userAgent) {
        this.usuario = usuario;
        this.token = token;
        this.fechaExpiracion = fechaExpiracion;
        this.activa = activa;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public usuarioEntitie getUsuario() { return usuario; }
    public void setUsuario(usuarioEntitie usuario) { this.usuario = usuario; }

    public String getSessionToken() { return token; }
    public void setSessionToken(String sessionToken) { this.token = sessionToken; }

    public OffsetDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(OffsetDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public OffsetDateTime getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(OffsetDateTime fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }
}
