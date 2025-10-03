package com.organization.Auto_TEC.Entities;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "administradores")
public class administradorEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roles_id", nullable = false)
    private Rol rol; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamentos_id")
    private Departamentos departamento;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private OffsetDateTime fechaCreacion;

    @Column(nullable = false)
    private Boolean activo = true;

    public administradorEntitie() { }

    public administradorEntitie(Rol rol, Departamentos departamento, String username, 
                              String email, String passwordHash, Boolean activo) {
        this.rol = rol;
        this.departamento = departamento;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.activo = (activo != null) ? activo : true;
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

    public Departamentos getDepartamento() { 
        return departamento; 
    }

    public void setDepartamento(Departamentos departamento) { 
        this.departamento = departamento; 
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public OffsetDateTime getFechaCreacion() { 
        return fechaCreacion; 
    }

    public void setFechaCreacion(OffsetDateTime fechaCreacion) { 
        this.fechaCreacion = fechaCreacion; 
    }

    public Boolean getActivo() { 
        return activo; 
    }

    public void setActivo(Boolean activo) { 
        this.activo = activo; 
    }
}