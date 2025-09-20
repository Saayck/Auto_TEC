package com.organization.Auto_TEC.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
    @Bean("/modelos")
    public String modelos(){
        return "modelos";
    }
    @Bean("/ventas")
    public String ventas(){
        return "ventas";
    }
    @Bean("/servicios")
    public String servicios(){
        return "servicios";
    }
    @Bean("/financiacion")
    public String financiacion(){
        return "financiacion";
    }
    @Bean("/gestion")
    public String gestion(){
        return "gestion";
    }
    @Bean ("/contacto")
    public String contacto(){
        return "contacto";
    }
}
