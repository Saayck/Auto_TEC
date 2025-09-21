package com.organization.Auto_TEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class paginaController {

    @GetMapping({"/","/index"})
    public String index() {
        return "index";
    }
    @GetMapping("/modelos")
    public String modelos() {
        return "modelos";
    }
    @GetMapping("/ventas")
    public String ventas() {
        return "ventas";
    }
    @GetMapping("/servicios")
    public String servicios() {
        return "servicios";
    }
    @GetMapping("/financiamiento")
    public String financiamiento() {
        return "financiamiento";
    }
    @GetMapping("/gestion")
    public String gestion() {
        return "gestion";
    }
    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }
}
