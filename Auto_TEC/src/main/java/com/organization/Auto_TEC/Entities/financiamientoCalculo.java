package com.organization.Auto_TEC.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "calculos_financiamiento")
public class financiamientoCalculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private usuarioEntitie usuario;

    @Column(name = "modelo_vehiculo", length = 100, nullable = false)
    private String modeloVehiculo;

    @Column(name = "precio_vehiculo", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioVehiculo;

    @Column(name = "cuota_inicial", nullable = false, precision = 12, scale = 2)
    private BigDecimal cuotaInicial;

    @Column(name = "plazo_meses", nullable = false)
    private Integer plazoMeses;

    @Column(name = "tasa_interes", nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInteres; // % anual, ej. 12.50

    @Column(name = "cuota_mensual", nullable = false, precision = 10, scale = 2)
    private BigDecimal cuotaMensual;

    @Column(name = "total_financiado", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalFinanciado;

    @CreationTimestamp
    @Column(name = "fecha_calculo", updatable = false)
    private LocalDateTime fechaCalculo;

    public financiamientoCalculo() {}

    public financiamientoCalculo(usuarioEntitie usuario,
                                 String modeloVehiculo,
                                 BigDecimal precioVehiculo,
                                 BigDecimal cuotaInicial,
                                 Integer plazoMeses,
                                 BigDecimal tasaInteres,
                                 BigDecimal cuotaMensual,
                                 BigDecimal totalFinanciado) {
        this.usuario = usuario;
        this.modeloVehiculo = modeloVehiculo;
        this.precioVehiculo = precioVehiculo;
        this.cuotaInicial = cuotaInicial;
        this.plazoMeses = plazoMeses;
        this.tasaInteres = tasaInteres;
        this.cuotaMensual = cuotaMensual;
        this.totalFinanciado = totalFinanciado;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public usuarioEntitie getUsuario() { return usuario; }
    public void setUsuario(usuarioEntitie usuario) { this.usuario = usuario; }

    public String getModeloVehiculo() { return modeloVehiculo; }
    public void setModeloVehiculo(String modeloVehiculo) { this.modeloVehiculo = modeloVehiculo; }

    public BigDecimal getPrecioVehiculo() { return precioVehiculo; }
    public void setPrecioVehiculo(BigDecimal precioVehiculo) { this.precioVehiculo = precioVehiculo; }

    public BigDecimal getCuotaInicial() { return cuotaInicial; }
    public void setCuotaInicial(BigDecimal cuotaInicial) { this.cuotaInicial = cuotaInicial; }

    public Integer getPlazoMeses() { return plazoMeses; }
    public void setPlazoMeses(Integer plazoMeses) { this.plazoMeses = plazoMeses; }

    public BigDecimal getTasaInteres() { return tasaInteres; }
    public void setTasaInteres(BigDecimal tasaInteres) { this.tasaInteres = tasaInteres; }

    public BigDecimal getCuotaMensual() { return cuotaMensual; }
    public void setCuotaMensual(BigDecimal cuotaMensual) { this.cuotaMensual = cuotaMensual; }

    public BigDecimal getTotalFinanciado() { return totalFinanciado; }
    public void setTotalFinanciado(BigDecimal totalFinanciado) { this.totalFinanciado = totalFinanciado; }

    public LocalDateTime getFechaCalculo() { return fechaCalculo; }
    public void setFechaCalculo(LocalDateTime fechaCalculo) { this.fechaCalculo = fechaCalculo; }
}
