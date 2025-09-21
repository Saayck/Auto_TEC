package com.organization.Auto_TEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinanciamientoController {

    @GetMapping("/financiamiento")
    public String view() {
        return "financiamiento";
    }
}
