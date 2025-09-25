package com.organization.Auto_TEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class paginaController {
    @GetMapping({"/","/animacion"})
    public String index() {
        return "page/animacion";
    }
    @GetMapping("/index")
    public String inicio() {
        return "page/index";
    }
    @GetMapping("/modelos")
    public String modelos() {
        return "page/modelos";
    }
    @GetMapping("/ventas")
    public String ventas() {
        return "page/ventas";
    }
    @GetMapping("/servicios")
    public String servicios() {
        return "page/servicios";
    }
    @GetMapping("/financiamiento")
    public String financiamiento() {
        return "page/financiamiento";
    }
    @GetMapping("/gestion")
    public String gestion() {
        return "page/gestion";
    }
    @GetMapping("/contacto")
    public String contacto() {
        return "page/contacto";
    }
    @GetMapping("/login")
        public String login(){
        return "page/login";
      }
    @GetMapping("/registro")
    public String registro() {
        return "page/registro";
    }
    
}