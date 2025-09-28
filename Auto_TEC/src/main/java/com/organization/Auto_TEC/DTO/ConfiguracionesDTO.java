package com.organization.Auto_TEC.DTO;

public class ConfiguracionesDTO {
    private Long id;
    private String clave;
    private String valor;
    private String descripcion;

    // Constructor
    public ConfiguracionesDTO() {}

    public ConfiguracionesDTO(Long id, String clave, String valor, String descripcion) {
        this.id = id;
        this.clave = clave;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public ConfiguracionesDTO(String clave, String valor, String descripcion) {
        this.clave = clave;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}