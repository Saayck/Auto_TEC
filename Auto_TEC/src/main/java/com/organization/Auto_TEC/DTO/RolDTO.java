package com.organization.Auto_TEC.DTO;

public class RolDTO {
    private Long id;
    private String nombre;

    // Constructor vacío
    public RolDTO() {}

    // Constructor con campos básicos
    public RolDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor solo con nombre (para creación)
    public RolDTO(String nombre) {
        this.nombre = nombre;
    }

    // Constructor desde la entidad
    public static RolDTO fromEntity(com.organization.Auto_TEC.Entities.Rol entity) {
        return new RolDTO(
            entity.getId(),
            entity.getNombre()
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
    
    // Métodos equals() y hashCode() para comparación
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolDTO rolDTO = (RolDTO) o;

        if (!id.equals(rolDTO.id)) return false;
        return nombre.equals(rolDTO.nombre);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nombre.hashCode();
        return result;
    }
}