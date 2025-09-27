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
    
    @Column(name = "nombre",nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tasa_interes", nullable = false)
    private double tasa_interes;

    @Column(name = "plazo_min", nullable = false)
    private int plazo_min;

    @Column(name = "plazo_max", nullable = false )
    private int plazo_max;

    @Column(name = "enganche_minimo", nullable = false)
    private double enganche_minimo;

    @Column(name = "requisitos", nullable = false, columnDefinition = "TEXT")
    private String requisitos;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;
     
    
}
