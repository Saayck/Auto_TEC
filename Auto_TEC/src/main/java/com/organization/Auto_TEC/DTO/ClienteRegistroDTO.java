package com.organization.Auto_TEC.DTO;

import java.time.LocalDate;

// DTO para Creación/Registro de Cliente

public class ClienteRegistroDTO {
    private Long usuarioId;
    private String telefono;
    private String direccion;
    private String tipoDocumento;
    private String numeroDocumento;
    private LocalDate fechaNacimiento;

    // Constructores
    public ClienteRegistroDTO() {}

    public ClienteRegistroDTO(Long usuarioId, String telefono, String direccion, 
                            String tipoDocumento, String numeroDocumento, LocalDate fechaNacimiento) {
        this.usuarioId = usuarioId;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoDocumento = (tipoDocumento != null) ? tipoDocumento : "DNI";
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = (tipoDocumento != null) ? tipoDocumento : "DNI";
    }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}