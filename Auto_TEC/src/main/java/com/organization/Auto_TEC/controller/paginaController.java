package com.organization.Auto_TEC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class paginaController {
    @GetMapping({"/","/animacion"})
    public String index() {
        return "animacion";
    }
    @GetMapping("/index")
    public String inicio() {
        return "/index";
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
