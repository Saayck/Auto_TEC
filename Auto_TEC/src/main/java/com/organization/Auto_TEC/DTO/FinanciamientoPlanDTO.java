package com.organization.Auto_TEC.DTO;

// DTOs para financiamientoEntitie (Planes de Financiamiento)

public class FinanciamientoPlanDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private double tasaInteres;
    private int plazoMin;
    private int plazoMax;
    private double engancheMinimo;
    private String requisitos;
    private boolean activo;

    // Constructores
    public FinanciamientoPlanDTO() {}

    public FinanciamientoPlanDTO(Long id, String nombre, String descripcion, double tasaInteres, 
                                int plazoMin, int plazoMax, double engancheMinimo, String requisitos, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tasaInteres = tasaInteres;
        this.plazoMin = plazoMin;
        this.plazoMax = plazoMax;
        this.engancheMinimo = engancheMinimo;
        this.requisitos = requisitos;
        this.activo = activo;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getTasaInteres() { return tasaInteres; }
    public void setTasaInteres(double tasaInteres) { this.tasaInteres = tasaInteres; }

    public int getPlazoMin() { return plazoMin; }
    public void setPlazoMin(int plazoMin) { this.plazoMin = plazoMin; }

    public int getPlazoMax() { return plazoMax; }
    public void setPlazoMax(int plazoMax) { this.plazoMax = plazoMax; }

    public double getEngancheMinimo() { return engancheMinimo; }
    public void setEngancheMinimo(double engancheMinimo) { this.engancheMinimo = engancheMinimo; }

    public String getRequisitos() { return requisitos; }
    public void setRequisitos(String requisitos) { this.requisitos = requisitos; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}