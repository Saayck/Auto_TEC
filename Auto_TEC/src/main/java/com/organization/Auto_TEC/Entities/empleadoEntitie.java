package com.organization.Auto_TEC.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class empleadoEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Rol rol;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "email", length = 100, nullable = false ,unique = true)
    private String email;

    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;
    
    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fechaContratacion;
    
    public empleadoEntitie(){}

    public empleadoEntitie(Long id,
               Rol rol,
               String nombres,
               String apellidos,
               String email,
               String telefono,
               boolean activo,
               LocalDate fechaContratacion) {
    this.id = id;
    this.rol = rol;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.email = email;
    this.telefono = telefono;
    this.activo = activo;
    this.fechaContratacion = fechaContratacion;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Rol getRol() {
    return rol;
}

public void setRol(Rol rol) {
    this.rol = rol;
}

public String getNombres() {
    return nombres;
}

public void setNombres(String nombres) {
    this.nombres = nombres;
}

public String getApellidos() {
    return apellidos;
}

public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public boolean isActivo() {
    return activo;
}

public void setActivo(boolean activo) {
    this.activo = activo;
}

public LocalDate getFechaContratacion() {
    return fechaContratacion;
}

public void setFechaContratacion(LocalDate fechaContratacion) {
    this.fechaContratacion = fechaContratacion;
}
}
