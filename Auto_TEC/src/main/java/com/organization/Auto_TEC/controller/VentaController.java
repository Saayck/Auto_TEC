package com.organization.Auto_TEC.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class VentaController {

    @GetMapping("/nueva_venta")
    public String mostrarFormularioNuevaVenta(Model model) {
        try {
            System.out.println("=== INICIANDO NUEVA_VENTA ===");
            model.addAttribute("venta", new VentaDTOTemp());
            
            model.addAttribute("clientes", Arrays.asList(
                new ClienteTemp(1L, "Juan", "Pérez", "12345678", "juan@email.com", "123456789"),
                new ClienteTemp(2L, "María", "Gómez", "87654321", "maria@email.com", "987654321")
            ));
            
            model.addAttribute("modelos", Arrays.asList(
                new ModeloTemp(1L, "Corolla", "Toyota", 25000.0, "2024", "Rojo"),
                new ModeloTemp(2L, "Civic", "Honda", 27000.0, "2024", "Azul")
            ));
            
            model.addAttribute("vendedores", Arrays.asList(
                new VendedorTemp(1L, "Carlos", "López", "Vendedor", "carlos@email.com", "555-1234", 500.0, 5),
                new VendedorTemp(2L, "Ana", "Martínez", "Vendedor", "ana@email.com", "555-5678", 600.0, 8)
            ));
            
            model.addAttribute("metodosPago", Arrays.asList(
                new MetodoPagoTemp(1L, "Contado"),
                new MetodoPagoTemp(2L, "Crédito")
            ));
            
            System.out.println("=== DATOS CARGADOS EXITOSAMENTE ===");
            return "admin/nueva_venta";
            
        } catch (Exception e) {
            System.out.println("=== ERROR EN NUEVA_VENTA ===");
            e.printStackTrace();
            model.addAttribute("error", "Error al cargar el formulario: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/gestion_ventas")
    public String gestionVentas(Model model) {
        // Datos temporales para la tabla de gestión
        model.addAttribute("ventas", Arrays.asList(
            new VentaTableTemp(1L, "Juan Pérez", "Toyota Corolla", "Carlos López", 25000.0, "Contado", "2024-10-04", "RESERVADO")
        ));
        return "admin/gestion_ventas";
    }
    
    // CLASE VendedorTemp ACTUALIZADA CON TODOS LOS ATRIBUTOS NECESARIOS
    public static class VendedorTemp {
        private Long id;
        private String nombres;
        private String apellidos;
        private String cargo;
        private String email;
        private String telefono;
        private Double comisionBase;
        private Integer ventasEsteMes;
        
        public VendedorTemp(Long id, String nombres, String apellidos, String cargo, 
                           String email, String telefono, Double comisionBase, Integer ventasEsteMes) {
            this.id = id;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.cargo = cargo;
            this.email = email;
            this.telefono = telefono;
            this.comisionBase = comisionBase;
            this.ventasEsteMes = ventasEsteMes;
        }
        
        // Getters
        public Long getId() { return id; }
        public String getNombres() { return nombres; }
        public String getApellidos() { return apellidos; }
        public String getCargo() { return cargo; }
        public String getEmail() { return email; }
        public String getTelefono() { return telefono; }
        public Double getComisionBase() { return comisionBase; }
        public Integer getVentasEsteMes() { return ventasEsteMes; }
    }
    
    // Las otras clases se mantienen igual...
    public static class VentaTableTemp {
        private Long id;
        private String cliente;
        private String auto;
        private String vendedor;
        private Double precioFinal;
        private String metodoPago;
        private String fechaVenta;
        private String estado;
        
        public VentaTableTemp(Long id, String cliente, String auto, String vendedor, 
                             Double precioFinal, String metodoPago, String fechaVenta, String estado) {
            this.id = id;
            this.cliente = cliente;
            this.auto = auto;
            this.vendedor = vendedor;
            this.precioFinal = precioFinal;
            this.metodoPago = metodoPago;
            this.fechaVenta = fechaVenta;
            this.estado = estado;
        }
        
        public Long getId() { return id; }
        public String getCliente() { return cliente; }
        public String getAuto() { return auto; }
        public String getVendedor() { return vendedor; }
        public Double getPrecioFinal() { return precioFinal; }
        public String getMetodoPago() { return metodoPago; }
        public String getFechaVenta() { return fechaVenta; }
        public String getEstado() { return estado; }
    }
    
    public static class VentaDTOTemp {
        private Long id;
        private Long clienteId;
        private Long modeloId;
        private Long vendedorId;
        private Long metodoPagoId;
        private Double precioVenta;
        private String estado = "RESERVADO";
        private Double comisionVendedor;
        private String notas;
        
        // Getters y Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public Long getClienteId() { return clienteId; }
        public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
        public Long getModeloId() { return modeloId; }
        public void setModeloId(Long modeloId) { this.modeloId = modeloId; }
        public Long getVendedorId() { return vendedorId; }
        public void setVendedorId(Long vendedorId) { this.vendedorId = vendedorId; }
        public Long getMetodoPagoId() { return metodoPagoId; }
        public void setMetodoPagoId(Long metodoPagoId) { this.metodoPagoId = metodoPagoId; }
        public Double getPrecioVenta() { return precioVenta; }
        public void setPrecioVenta(Double precioVenta) { this.precioVenta = precioVenta; }
        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }
        public Double getComisionVendedor() { return comisionVendedor; }
        public void setComisionVendedor(Double comisionVendedor) { this.comisionVendedor = comisionVendedor; }
        public String getNotas() { return notas; }
        public void setNotas(String notas) { this.notas = notas; }
    }
    
    public static class ClienteTemp {
        private Long id;
        private String nombres;
        private String apellidos;
        private String dni;
        private String email;
        private String telefono;
        
        public ClienteTemp(Long id, String nombres, String apellidos, String dni, String email, String telefono) {
            this.id = id;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.dni = dni;
            this.email = email;
            this.telefono = telefono;
        }
        
        public Long getId() { return id; }
        public String getNombres() { return nombres; }
        public String getApellidos() { return apellidos; }
        public String getDni() { return dni; }
        public String getEmail() { return email; }
        public String getTelefono() { return telefono; }
    }
    
    public static class ModeloTemp {
        private Long id;
        private String nombre;
        private String marca;
        private Double precio;
        private String anio;
        private String color;
        
        public ModeloTemp(Long id, String nombre, String marca, Double precio, String anio, String color) {
            this.id = id;
            this.nombre = nombre;
            this.marca = marca;
            this.precio = precio;
            this.anio = anio;
            this.color = color;
        }
        
        public Long getId() { return id; }
        public String getNombre() { return nombre; }
        public String getMarca() { return marca; }
        public Double getPrecio() { return precio; }
        public String getAnio() { return anio; }
        public String getColor() { return color; }
    }
    
    public static class MetodoPagoTemp {
        private Long id;
        private String nombre;
        
        public MetodoPagoTemp(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
        
        public Long getId() { return id; }
        public String getNombre() { return nombre; }
    }
}