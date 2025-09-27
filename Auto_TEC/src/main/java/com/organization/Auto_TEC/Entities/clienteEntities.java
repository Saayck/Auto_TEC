package com.organization.Auto_TEC.Entities;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class clienteEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private usuarioEntitie usuario;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;
    
    @Column(name = "direccion", nullable = false,columnDefinition = "TEXT")
    private String direccion;

    @Column(name = "tipo_documento", nullable = false, length = 20)
    private String tipo_documento = "DNI";

    @Column(name = "numero_documento", nullable = false, length = 8, unique = true)
    private String numero_documento;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @CreationTimestamp
    @Column(name = "fecha_registro")
    private OffsetDateTime fecha_registro;

    public clienteEntities() {}
    public clienteEntities(Long id,
                           usuarioEntitie usuario,
                           String telefono,
                           String direccion,
                           String tipo_documento,
                           String numero_documento,
                           LocalDate fecha_nacimiento) {
        this.id = id;
        this.usuario = usuario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo_documento = (tipo_documento != null) ? tipo_documento : "DNI";
        this.numero_documento = numero_documento;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public usuarioEntitie getUsuario() {
        return usuario;
    }

    public void setUsuario(usuarioEntitie usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public OffsetDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(OffsetDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
