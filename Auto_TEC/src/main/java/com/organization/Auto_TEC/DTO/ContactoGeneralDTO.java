package com.organization.Auto_TEC.DTO;

import java.time.LocalDateTime;

import com.organization.Auto_TEC.Entities.contactoEstado;
import com.organization.Auto_TEC.Entities.contactoTipo;

public class ContactoGeneralDTO {
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String asunto;
    private String mensaje;
    private contactoTipo tipoConsulta;
    private LocalDateTime fechaContacto;
    private contactoEstado estado;

    // Constructor
    public ContactoGeneralDTO() {}

    public ContactoGeneralDTO(Long id, String nombre, String email, String telefono, 
                             String asunto, String mensaje, contactoTipo tipoConsulta, 
                             LocalDateTime fechaContacto, contactoEstado estado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.tipoConsulta = tipoConsulta;
        this.fechaContacto = fechaContacto;
        this.estado = (estado != null) ? estado : contactoEstado.NUEVO;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public LocalDateTime getFechaContacto() { return fechaContacto; }
    public void setFechaContacto(LocalDateTime fechaContacto) { this.fechaContacto = fechaContacto; }

    public contactoEstado getEstado() { return estado; }
    public void setEstado(contactoEstado estado) { 
        this.estado = (estado != null) ? estado : contactoEstado.NUEVO;
    }
}