package com.organization.Auto_TEC.Entities;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class usuarioEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol_id",referencedColumnName = "id" ,nullable = false)
    private rolEntitie rol;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 255, unique = true)
    private String password_hash;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "nombres", nullable = false, length = 100,unique = true)
    private String nombres;
    
    @Column(name = "apellidos", nullable = false, length = 100,unique = true)
    private String apellidos;

    @Column(name = "activo", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean activo;

    @CreationTimestamp
    @Column(name = "fecha_registro", insertable = false, updatable = false, columnDefinition = "TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime fechaRegistro;

    @Column(name = "ultimo_login")
    private OffsetDateTime ultimo_login;
}
