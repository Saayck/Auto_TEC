package com.organization.Auto_TEC.Entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "ventas")
public class ventasEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private usuarioEntitie cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id")
    private modelosEntitie modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor_id")
    private usuarioEntitie vendedor;

    @CreationTimestamp
    @Column(name = "fecha_venta", updatable = false)
    private OffsetDateTime fechaVenta;

    @Column(name = "precio_venta", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ventaEstado estado = ventaEstado.RESERVADO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pago_id")
    private pagoMetodo metodo_pago;

    @Column(name = "comision_vendedor", precision = 10, scale = 2,nullable = false)
    private BigDecimal comisionVendedor;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String notas;


    public ventasEntitie() { }

    public ventasEntitie(usuarioEntitie cliente,
                 modelosEntitie modelo,
                 usuarioEntitie vendedor,
                 BigDecimal precioVenta,
                 ventaEstado estado,
                 pagoMetodo metodo_pago,
                 BigDecimal comisionVendedor,
                 String notas) {
        this.cliente = cliente;
        this.modelo = modelo;
        this.vendedor = vendedor;
        this.precioVenta = precioVenta;
        this.estado = (estado != null) ? estado : ventaEstado.RESERVADO;
        this.metodo_pago = metodo_pago;
        this.comisionVendedor = comisionVendedor;
        this.notas = notas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public usuarioEntitie getCliente() { return cliente; }
    public void setCliente(usuarioEntitie cliente) { this.cliente = cliente; }

    public modelosEntitie getModelo() { return modelo; }
    public void setModelo(modelosEntitie modelo) { this.modelo = modelo; }

    public usuarioEntitie getVendedor() { return vendedor; }
    public void setVendedor(usuarioEntitie vendedor) { this.vendedor = vendedor; }

    public OffsetDateTime getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(OffsetDateTime fechaVenta) { this.fechaVenta = fechaVenta; }

    public BigDecimal getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(BigDecimal precioVenta) { this.precioVenta = precioVenta; }

    public ventaEstado getEstado() { return estado; }
    public void setEstado(ventaEstado estado) { this.estado = estado; }

    public pagoMetodo getMetodo_pago() { return metodo_pago; }
    public void setMetodoPago(pagoMetodo metodo_pago) { this.metodo_pago = metodo_pago; }

    public BigDecimal getComisionVendedor() { return comisionVendedor; }
    public void setComisionVendedor(BigDecimal comisionVendedor) { this.comisionVendedor = comisionVendedor; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}