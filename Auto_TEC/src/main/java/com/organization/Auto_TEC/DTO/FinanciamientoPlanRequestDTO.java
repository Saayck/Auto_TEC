package com.organization.Auto_TEC.DTO;

// DTO para Creación/Actualización

public class FinanciamientoPlanRequestDTO {
    private String nombre;
    private String descripcion;
    private double tasaInteres;
    private int plazoMin;
    private int plazoMax;
    private double engancheMinimo;
    private String requisitos;
    private boolean activo = true;

    // Constructores y Getters/Setters
    public FinanciamientoPlanRequestDTO() {}

    // Getters y Setters
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