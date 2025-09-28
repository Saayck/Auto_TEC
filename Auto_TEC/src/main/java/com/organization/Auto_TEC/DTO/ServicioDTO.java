package com.organization.Auto_TEC.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServicioDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String icono;
    private BigDecimal precio;
    private String duracionEstimada;
    private boolean disponible;
    private LocalDateTime fechaCreacion;

    // Constructor vacío
    public ServicioDTO() {}

    // Constructor con todos los campos
    public ServicioDTO(Long id, String nombre, String descripcion, String icono, 
                      BigDecimal precio, String duracionEstimada, boolean disponible, 
                      LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.precio = precio;
        this.duracionEstimada = duracionEstimada;
        this.disponible = disponible;
        this.fechaCreacion = fechaCreacion;
    }

    // Constructor desde la entidad
    public static ServicioDTO fromEntity(com.organization.Auto_TEC.Entities.Servicios entity) {
        return new ServicioDTO(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getIcono(),
            entity.getPrecio(),
            entity.getDuracionEstimada(),
            entity.isDisponible(),
            entity.getFechaCreacion()
        );
    }

    // Constructor para creación/actualización (sin id y fechaCreacion)
    public ServicioDTO(String nombre, String descripcion, String icono, 
                      BigDecimal precio, String duracionEstimada, boolean disponible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.precio = precio;
        this.duracionEstimada = duracionEstimada;
        this.disponible = disponible;
    }

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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(String duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}