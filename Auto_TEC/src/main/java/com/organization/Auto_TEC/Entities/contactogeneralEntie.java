package com.organization.Auto_TEC.Entities;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "contactos_general")
public class contactogeneralEntie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",length = 100, nullable = false)
    private String nombre;

    @Column(name = "email",length = 100, nullable = false)
    private String email;

    @Column(name = "telefono",length = 20)
    private String telefono;

    @Column(name = "asunto",length = 200, nullable = false)
    private String asunto;

    @Column(name = "mensaje",nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_consulta", length = 50)
    private contactoTipo tipoConsulta;

    @CreationTimestamp
    @Column(name = "fecha_contacto", updatable = false)
    private LocalDateTime fechaContacto;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private contactoEstado estado = contactoEstado.NUEVO;

    // ===== Constructores =====
    public contactogeneralEntie() {}

    // “Lleno” (sin id ni fecha_contacto; los maneja JPA/BD)
    public contactogeneralEntie(String nombre,
                           String email,
                           String telefono,
                           String asunto,
                           String mensaje,
                           contactoTipo tipoConsulta,
                           contactoEstado estado) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.tipoConsulta = tipoConsulta;
        this.estado = (estado != null) ? estado : contactoEstado.NUEVO;
    }

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
    public void setEstado(contactoEstado estado) { this.estado = estado; }

}

