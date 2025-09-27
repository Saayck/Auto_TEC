package com.organization.Auto_TEC.Entities;

import java.time.OffsetDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "administradores")
public class administradorEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "roles_id", nullable = false)
    private Rol rol = Rol.USUARIO; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamentos_id", nullable = false)
    private Departamentos departamento;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private OffsetDateTime fechaCreacion;

    @Column(nullable = false)
    private Boolean activo = true;

    public administradorEntitie() { }

    public administradorEntitie(Rol rol, Departamentos departamento, Boolean activo) {
        this.rol = rol;
        this.departamento = departamento;
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


