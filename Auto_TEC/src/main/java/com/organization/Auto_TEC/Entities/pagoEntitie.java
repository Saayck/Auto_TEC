package com.organization.Auto_TEC.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class pagoEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id")
    private ventasEntitie venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pago_id")
    private pagoMetodo metodoPago;

    @Column(name = "monto",nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;

    @CreationTimestamp
    @Column(name = "fecha_pago", updatable = false)
    private LocalDateTime fechaPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago", length = 20, nullable = false)
    private pagoEstado estadoPago = pagoEstado.PENDIENTE;


    public pagoEntitie() {}

    public pagoEntitie(ventasEntitie venta,
                pagoMetodo metodoPago,
                BigDecimal monto,
                pagoEstado estadoPago) {
        this.venta = venta;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estadoPago = (estadoPago != null) ? estadoPago : pagoEstado.PENDIENTE;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ventasEntitie getVenta() { 
        return venta; 
    }
    public void setVenta(ventasEntitie venta) { 
        this.venta = venta; 
    }

    public pagoMetodo getMetodoPago() { return metodoPago; }
    public void setMetodoPago(pagoMetodo metodoPago) { this.metodoPago = metodoPago; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }

    public pagoEstado getEstadoPago() { return estadoPago; }
    public void setEstadoPago(pagoEstado estadoPago) { this.estadoPago = estadoPago; }
}
