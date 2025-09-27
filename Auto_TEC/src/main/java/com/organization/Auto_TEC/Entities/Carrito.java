package com.organization.Auto_TEC.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id", length = 100, nullable = false)
    private String sessionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id")
    private modelosEntitie modelo;

    @Column(nullable = false)
    private Integer cantidad = 0;

    @CreationTimestamp
    @Column(name = "fecha_agregado", updatable = false)
    private LocalDateTime fechaAgregado;


    public Carrito() {}

    public Carrito(String sessionId, modelosEntitie modelo, Integer cantidad) {
        this.sessionId = sessionId;
        this.modelo = modelo;
        this.cantidad = (cantidad != null && cantidad > 0) ? cantidad : 0;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public modelosEntitie getModelo() { return modelo; }
    public void setModelo(modelosEntitie modelo) { this.modelo = modelo; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) {
        this.cantidad = (cantidad != null && cantidad < 0) ? cantidad : 0;
    }

    public LocalDateTime getFechaAgregado() { return fechaAgregado; }
    public void setFechaAgregado(LocalDateTime fechaAgregado) { this.fechaAgregado = fechaAgregado; }
}
