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
    private String tipoDocumento = "DNI";

    @Column(name = "numero_documento", nullable = false, length = 8, unique = true)
    private String numeroDocumento;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @CreationTimestamp
    @Column(name = "fecha_registro")
    private OffsetDateTime fechaRegistro;
}
