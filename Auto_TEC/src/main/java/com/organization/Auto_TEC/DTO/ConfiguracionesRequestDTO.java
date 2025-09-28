package com.organization.Auto_TEC.DTO;

// DTO para solicitudes de creación/actualización de configuraciones

public class ConfiguracionesRequestDTO {
    private String clave;
    private String valor;
    private String descripcion;

    // Constructor
    public ConfiguracionesRequestDTO() {}

    public ConfiguracionesRequestDTO(String clave, String valor, String descripcion) {
        this.clave = clave;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}