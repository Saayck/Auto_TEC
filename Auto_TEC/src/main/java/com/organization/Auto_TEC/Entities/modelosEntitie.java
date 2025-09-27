package com.organization.Auto_TEC.Entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "modelos")
public class modelosEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",length = 50, nullable = false)
    private String nombre;

    @Column(name = "marca",length = 50, nullable = false)
    private String marca;

    @Column(name = "descripcion",columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(name = "motor",length = 50,nullable = false)
    private String motor;

    @Column(name = "potencia",length = 50,nullable = false)
    private String potencia;

    @Column(name = "velocidad_max", length = 50, nullable = false)
    private String velocidadMax;

    @Column(name = "aceleracion",length = 50)
    private String aceleracion;

    @Column(name = "precio",nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "imagen_url", length = 255, nullable = false)
    private String imagenUrl;

    @Column(name = "destacado",nullable = false)
    private boolean destacado = false;

    @Column(name= "stock",nullable = false)
    private int stock = 1;

    @Column(name ="categoria",length = 20)
    private String categoria = "HYPERCAR";

    @Column(name="activo",nullable = false)
    private boolean activo = true;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false, nullable = false)
    private OffsetDateTime fecha_creacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion",nullable = false)
    private OffsetDateTime fecha_actualizacion;

    public modelosEntitie() {}

    public modelosEntitie(String nombre,
                  String marca,
                  String descripcion,
                  String motor,
                  String potencia,
                  String velocidadMax,
                  String aceleracion,
                  BigDecimal precio,
                  String imagenUrl,
                  boolean destacado,
                  int stock,
                  String categoria,
                  boolean activo) {
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.motor = motor;
        this.potencia = potencia;
        this.velocidadMax = velocidadMax;
        this.aceleracion = aceleracion;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.destacado = destacado;
        this.stock = (stock > 0) ? stock : 1;
        this.categoria = (categoria != null && !categoria.isBlank()) ? categoria : "HYPERCAR";
        this.activo = activo;
    }

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

    public String getMarca() { 
        return marca; 
    }
    public void setMarca(String marca) { 
        this.marca = marca; 
    }

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    public String getMotor() { 
        return motor; 
    }
    public void setMotor(String motor) { 
        this.motor = motor; 
    }

    public String getPotencia() { 
        return potencia; 
    }
    public void setPotencia(String potencia) { 
        this.potencia = potencia; 
    }

    public String getVelocidadMax() { 
        return velocidadMax; 
    }
    public void setVelocidadMax(String velocidadMax) { 
        this.velocidadMax = velocidadMax; 
    }

    public String getAceleracion() { 
        return aceleracion; 
    }
    public void setAceleracion(String aceleracion) { 
        this.aceleracion = aceleracion; 
    }

    public BigDecimal getPrecio() { 
        return precio; 
    }
    public void setPrecio(BigDecimal precio) { 
        this.precio = precio; 
    }

    public String getImagenUrl() { 
        return imagenUrl; 
    }
    public void setImagenUrl(String imagenUrl) { 
        this.imagenUrl = imagenUrl; 
    }

    public boolean isDestacado() { 
        return destacado; 
    }
    public void setDestacado(boolean destacado) { 
        this.destacado = destacado; 
    }

    public int getStock() { 
        return stock; 
    }
    public void setStock(int stock) { 
        this.stock = (stock > 0) ? stock : 1; 
    }

    public String getCategoria() { 
        return categoria; 
    }
    public void setCategoria(String categoria) {
        this.categoria = (categoria != null && !categoria.isBlank()) ? categoria : "HYPERCAR";
    }

    public boolean isActivo() { 
        return activo; 
    }
    public void setActivo(boolean activo) { 
        this.activo = activo; 
    }

    public OffsetDateTime getFecha_creacion() { 
        return fecha_creacion; 
    }
    public void setFecha_creacion(OffsetDateTime fecha_creacion) { 
        this.fecha_creacion = fecha_creacion; 
    }

    public OffsetDateTime getFecha_actualizacion() { 
        return fecha_actualizacion; 
    }
    public void setFecha_actualizacion(OffsetDateTime fecha_actualizacion) { 
        this.fecha_actualizacion = fecha_actualizacion; 
    }
}


