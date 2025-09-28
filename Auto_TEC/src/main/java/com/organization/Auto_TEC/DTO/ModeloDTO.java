package com.organization.Auto_TEC.DTO;

import java.math.BigDecimal;

public class ModeloDTO {
    private Long id;
    private String nombre;
    private String marca;
    private String descripcion;
    private String motor;
    private String potencia;
    private String velocidadMax;
    private String aceleracion;
    private BigDecimal precio;
    private String imagenUrl;
    private boolean destacado;
    private int stock;
    private String categoria;
    private boolean activo;

    // Constructor vacío
    public ModeloDTO() {}

    // Constructor con todos los campos
    public ModeloDTO(Long id, 
                    String nombre, 
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
        this.id = id;
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
        this.stock = stock;
        this.categoria = categoria;
        this.activo = activo;
    }

    // Constructor
    public static ModeloDTO fromEntity(com.organization.Auto_TEC.Entities.modelosEntitie entity) {
        return new ModeloDTO(
            entity.getId(),
            entity.getNombre(),
            entity.getMarca(),
            entity.getDescripcion(),
            entity.getMotor(),
            entity.getPotencia(),
            entity.getVelocidadMax(),
            entity.getAceleracion(),
            entity.getPrecio(),
            entity.getImagenUrl(),
            entity.isDestacado(),
            entity.getStock(),
            entity.getCategoria(),
            entity.isActivo()
        );
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
        this.stock = stock; 
    }

    public String getCategoria() { 
        return categoria; 
    }
    public void setCategoria(String categoria) { 
        this.categoria = categoria; 
    }

    public boolean isActivo() { 
        return activo; 
    }
    public void setActivo(boolean activo) { 
        this.activo = activo; 
    }
}