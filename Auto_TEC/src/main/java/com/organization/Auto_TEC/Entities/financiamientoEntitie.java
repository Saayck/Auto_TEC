package com.organization.Auto_TEC.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "financiamiento")
public class financiamientoEntitie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tasa_interes", nullable = false)
    private double tasaInteres;

    @Column(name = "plazo_min", nullable = false)
    private int plazoMin;

    @Column(name = "plazo_max", nullable = false)
    private int plazoMax;

    @Column(name = "enganche_minimo", nullable = false)
    private double engancheMinimo;

    @Column(name = "requisitos", nullable = false, columnDefinition = "TEXT")
    private String requisitos;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getPlazoMin() {
        return plazoMin;
    }

    public void setPlazoMin(int plazoMin) {
        this.plazoMin = plazoMin;
    }

    public int getPlazoMax() {
        return plazoMax;
    }

    public void setPlazoMax(int plazoMax) {
        this.plazoMax = plazoMax;
    }

    public double getEngancheMinimo() {
        return engancheMinimo;
    }

    public void setEngancheMinimo(double engancheMinimo) {
        this.engancheMinimo = engancheMinimo;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}