package com.organization.Auto_TEC.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "servicios")
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 50)
    private String icono;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "duracion_estimada", length = 50)
    private String duracionEstimada;

    @Column(nullable = false)
    private boolean disponible = true;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    public Servicios() {}

    public Servicios(String nombre,
                    String descripcion,
                    String icono,
                    BigDecimal precio,
                    String duracionEstimada,
                    boolean disponible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.precio = precio;
        this.duracionEstimada = duracionEstimada;
        this.disponible = disponible;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public String getDuracionEstimada() { return duracionEstimada; }
    public void setDuracionEstimada(String duracionEstimada) { this.duracionEstimada = duracionEstimada; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
