package com.organization.Auto_TEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class paginaController {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
