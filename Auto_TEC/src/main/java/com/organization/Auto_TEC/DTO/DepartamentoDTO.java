package com.organization.Auto_TEC.DTO;

public class DepartamentoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String ubicacion;

    // Constructor
    public DepartamentoDTO() {}

    public DepartamentoDTO(Long id, String nombre, String descripcion, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public DepartamentoDTO(String nombre, String descripcion, String ubicacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}