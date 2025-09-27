package com.organization.Auto_TEC.Entities;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "solicitudes_financiamiento")
public class financiamientoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private usuarioEntitie usuario;

    @Column(name = "nombre_solicitante", length = 100, nullable = false)
    private String nombreSolicitante;

    @Column(name = "email_solicitante", length = 100, nullable = false)
    private String emailSolicitante;

    @Column(name = "modelo_interes", length = 100, nullable = false)
    private String modeloInteres;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "plan_financiamiento", length = 100)
    private String planFinanciamiento;

    @CreationTimestamp
    @Column(name = "fecha_solicitud", updatable = false)
    private LocalDateTime fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20, nullable = false)
    private financiamientoEstadosolicitud estado = financiamientoEstadosolicitud.PENDIENTE;

    public financiamientoSolicitud() {}

    public financiamientoSolicitud(usuarioEntitie usuario,
                                   String nombreSolicitante,
                                   String emailSolicitante,
                                   String modeloInteres,
                                   String mensaje,
                                   String planFinanciamiento,
                                   financiamientoEstadosolicitud estado) {
        this.usuario = usuario;
        this.nombreSolicitante = nombreSolicitante;
        this.emailSolicitante = emailSolicitante;
        this.modeloInteres = modeloInteres;
        this.mensaje = mensaje;
        this.planFinanciamiento = planFinanciamiento;
        this.estado = (estado != null) ? estado : financiamientoEstadosolicitud.PENDIENTE;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public usuarioEntitie getUsuario() { return usuario; }
    public void setUsuario(usuarioEntitie usuario) { this.usuario = usuario; }

    public String getNombreSolicitante() { return nombreSolicitante; }
    public void setNombreSolicitante(String nombreSolicitante) { this.nombreSolicitante = nombreSolicitante; }

    public String getEmailSolicitante() { return emailSolicitante; }
    public void setEmailSolicitante(String emailSolicitante) { this.emailSolicitante = emailSolicitante; }

    public String getModeloInteres() { return modeloInteres; }
    public void setModeloInteres(String modeloInteres) { this.modeloInteres = modeloInteres; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getPlanFinanciamiento() { return planFinanciamiento; }
    public void setPlanFinanciamiento(String planFinanciamiento) { this.planFinanciamiento = planFinanciamiento; }

    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public financiamientoEstadosolicitud getEstado() { return estado; }
    public void setEstado(financiamientoEstadosolicitud estado) { this.estado = estado; }
}
