package com.organization.Auto_TEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentasController {

    @GetMapping("/ventas")
    public String view() {
        return "ventas";
    }
}
