package com.organization.Auto_TEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimacionController {

    // Home: entra aquí primero
    @GetMapping("/animacion")
    public String animacion() {
        return "animacion"; // templates/animacion.html
    }
}
