package com.organization.Auto_TEC.Entities;

import java.time.OffsetDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class usuarioEntitie { // Usa PascalCase para la clase

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false, length = 20)
    private Rol rol = Rol.CLIENTE; // <--- enum

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash; // mejor en camelCase

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "activo", nullable = false)
    private boolean activo = true; // evita null + aprovecha default en Java

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private OffsetDateTime fechaRegistro;

    @Column(name = "ultimo_login")
    private OffsetDateTime ultimoLogin;
}
