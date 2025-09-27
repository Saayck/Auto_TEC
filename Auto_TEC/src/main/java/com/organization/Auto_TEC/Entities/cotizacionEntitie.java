package com.organization.Auto_TEC.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "cotizaciones")
public class cotizacionEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private usuarioEntitie usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id")
    private modelosEntitie modelo;

    @Column(name = "nombre_solicitante", length = 50, nullable = false)
    private String nombre_solicitante;

    @Column(name = "email_solicitante", length = 50, nullable = false)
    private String email_solicitante;

    @Column(name = "modelo_interes", length = 50, nullable = false)
    private String modelo_interes;

    @CreationTimestamp
    @Column(name = "fecha_solicitud", updatable = false)
    private LocalDateTime fecha_solicitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20, nullable = false)
    private cotizacionEstado estado = cotizacionEstado.PENDIENTE;

    @Column(name = "notas", columnDefinition = "TEXT", nullable = false)
    private String notas;

    public cotizacionEntitie() {}

    public cotizacionEntitie(usuarioEntitie usuario,
                      modelosEntitie modelo,
                      String nombre_solicitante,
                      String email_solicitante,
                      String modelo_interes,
                      cotizacionEstado estado,
                      String notas) {
        this.usuario = usuario;
        this.modelo = modelo;
        this.nombre_solicitante = nombre_solicitante;
        this.email_solicitante = email_solicitante;
        this.modelo_interes = modelo_interes;
        this.estado = (estado != null) ? estado : cotizacionEstado.PENDIENTE;
        this.notas = notas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public usuarioEntitie getUsuario() { return usuario; }
    public void setUsuario(usuarioEntitie usuario) { this.usuario = usuario; }

    public modelosEntitie getModelo() { return modelo; }
    public void setModelo(modelosEntitie modelo) { this.modelo = modelo; }

    public String getNombre_solicitante() { return nombre_solicitante; }
    public void setNombreSolicitante(String nombreSolicitante) { this.nombre_solicitante = nombreSolicitante; }

    public String getEmail_solicitante() { return email_solicitante; }
    public void setEmailSolicitante(String emailSolicitante) { this.email_solicitante = emailSolicitante; }

    public String getModelo_interes() { return modelo_interes; }
    public void setModelo_interes(String modelo_interes) { this.modelo_interes = modelo_interes; }

    public LocalDateTime getFecha_solicitud() { return fecha_solicitud; }
    public void setFecha_solicitud(LocalDateTime fechaSolicitud) { this.fecha_solicitud = fechaSolicitud; }

    public cotizacionEstado getEstado() { return estado; }
    public void setEstado(cotizacionEstado estado) { this.estado = estado; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}
