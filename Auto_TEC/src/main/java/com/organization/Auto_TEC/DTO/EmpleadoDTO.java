package com.organization.Auto_TEC.DTO;

import java.time.LocalDate;

public class EmpleadoDTO {
    private Long id;
    private Long rolId;
    private String rolNombre;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private boolean activo;
    private LocalDate fechaContratacion;

    // Constructor
    public EmpleadoDTO() {}

    public EmpleadoDTO(Long id, Long rolId, String nombres, String apellidos, 
                      String email, String telefono, boolean activo, LocalDate fechaContratacion) {
        this.id = id;
        this.rolId = rolId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.activo = activo;
        this.fechaContratacion = fechaContratacion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }

    public String getRolNombre() { return rolNombre; }
    public void setRolNombre(String rolNombre) { this.rolNombre = rolNombre; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }
}