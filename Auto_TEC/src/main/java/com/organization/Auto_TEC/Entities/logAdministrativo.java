package com.organization.Auto_TEC.Entities;

import java.time.OffsetDateTime;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "logs_administrativos")
public class logAdministrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrador_id")
    private administradorEntitie administrador;

    @Column(name = "accion",length = 100, nullable = false)
    private String accion;

    @Column(name = "tabla_afectada", length = 50)
    private String tabla_afectada;

    @Column(name = "registro_id")
    private Long registro_id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "detalles", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> detalles;

    @CreationTimestamp
    @Column(name = "fecha_accion", updatable = false)
    private OffsetDateTime fecha_accion;


    public logAdministrativo() { }

    public logAdministrativo(administradorEntitie administrador,
                             String accion,
                             String tabla_afectada,
                             Long registro_id,
                             Map<String, Object> detalles) {
        this.administrador = administrador;
        this.accion = accion;
        this.tabla_afectada = tabla_afectada;
        this.registro_id = registro_id;
        this.detalles = detalles;
    }


    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public administradorEntitie getAdministrador() { 
        return administrador; 
    }

    public void setAdministrador(administradorEntitie administrador) { 
        this.administrador = administrador; 
    }

    public String getAccion() { 
        return accion; 
    }
    public void setAccion(String accion) { 
        this.accion = accion; 
    }

    public String getTabla_afectada() { 
        return tabla_afectada; 
    }
    public void setTabla_afectada(String tabla_afectada) { 
        this.tabla_afectada = tabla_afectada; 
    }

    public Long getRegistro_id() { 
        return registro_id; 
    }

    public void setRegistro_id(Long registro_id) { 
        this.registro_id = registro_id; 
    }

    public Map<String, Object> getDetalles() { 
        return detalles; 
    }

    public void setDetalles(Map<String, Object> detalles) { 
        this.detalles = detalles; 
    }

    public OffsetDateTime getFecha_accion() { 
        return fecha_accion; 
    }
    public void setFecha_accion(OffsetDateTime fecha_accion) { 
        this.fecha_accion = fecha_accion; 
    }
}
