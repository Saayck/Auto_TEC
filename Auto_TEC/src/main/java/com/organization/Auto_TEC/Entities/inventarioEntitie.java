package com.organization.Auto_TEC.Entities;

import java.time.OffsetDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class inventarioEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id", nullable = false)
    private modelosEntitie modelo;

    @Column(name = "cantidad", nullable = false)
    private int cantidad = 0;

    @Column(name = "ubicacion",length = 50, nullable = false)
    private String ubicacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion",nullable = false)
    private OffsetDateTime fecha_actualizacion;


    public inventarioEntitie() {}

    public inventarioEntitie(modelosEntitie modelo, Integer cantidad, String ubicacion) {
        this.modelo = modelo;
        this.cantidad = (cantidad != null) ? cantidad : 0;
        this.ubicacion = ubicacion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public modelosEntitie getModelo() { return modelo; }
    public void setModelo(modelosEntitie modelo) { this.modelo = modelo; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = (cantidad != null) ? cantidad : 0; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public OffsetDateTime getFecha_actualizacion() { return fecha_actualizacion; }
    public void setFecha_actualizacion(OffsetDateTime fecha_actualizacion) { this.fecha_actualizacion = fecha_actualizacion; }
}
