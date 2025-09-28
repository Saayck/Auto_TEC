package com.organization.Auto_TEC.DTO;

import com.organization.Auto_TEC.Entities.contactoEstado;

// DTO para actualizar el estado de un contacto

public class ContactoEstadoUpdateDTO {
    private contactoEstado estado;

    // Constructor
    public ContactoEstadoUpdateDTO() {}

    public ContactoEstadoUpdateDTO(contactoEstado estado) {
        this.estado = estado;
    }

    // Getters y Setters
    public contactoEstado getEstado() { return estado; }
    public void setEstado(contactoEstado estado) { this.estado = estado; }
}