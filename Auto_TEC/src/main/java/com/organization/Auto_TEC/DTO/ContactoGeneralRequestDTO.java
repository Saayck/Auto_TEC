package com.organization.Auto_TEC.DTO;

import com.organization.Auto_TEC.Entities.contactoTipo;

// DTO para creación de contactos generales

public class ContactoGeneralRequestDTO {
    private String nombre;
    private String email;
    private String telefono;
    private String asunto;
    private String mensaje;
    private contactoTipo tipoConsulta;

    // Constructor
    public ContactoGeneralRequestDTO() {}

    public ContactoGeneralRequestDTO(String nombre, String email, String telefono, 
                                    String asunto, String mensaje, contactoTipo tipoConsulta) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.tipoConsulta = tipoConsulta;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public contactoTipo getTipoConsulta() { return tipoConsulta; }
    public void setTipoConsulta(contactoTipo tipoConsulta) { this.tipoConsulta = tipoConsulta; }
}