package com.organization.Auto_TEC.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "citas")
public class citaEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private usuarioEntitie usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id")
    private empleadoEntitie empleado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cita", length = 50, nullable = false)
    private citaTipo tipoCita;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDateTime fechaCita;

    @Column(name = "duracion_estimada", nullable = false)
    private Integer duracionEstimada = 60;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20, nullable = false)
    private citaEstado estado = citaEstado.PENDIENTE;

    @Column(columnDefinition = "TEXT")
    private String notas;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    public citaEntitie() {}

    public citaEntitie(usuarioEntitie usuario,
                empleadoEntitie empleado,
                citaTipo tipoCita,
                LocalDateTime fechaCita,
                Integer duracionEstimada,
                citaEstado estado,
                String notas) {
        this.usuario = usuario;
        this.empleado = empleado;
        this.tipoCita = tipoCita;
        this.fechaCita = fechaCita;
        this.duracionEstimada = (duracionEstimada != null) ? duracionEstimada : 60;
        this.estado = (estado != null) ? estado : citaEstado.PENDIENTE;
        this.notas = notas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public usuarioEntitie getUsuario() { return usuario; }
    public void setUsuario(usuarioEntitie usuario) { this.usuario = usuario; }

    public empleadoEntitie getEmpleado() { return empleado; }
    public void setEmpleado(empleadoEntitie empleado) { this.empleado = empleado; }

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
