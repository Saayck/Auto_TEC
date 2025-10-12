package com.organization.Auto_TEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthViewController {

    @GetMapping("/login")
    public String mostrarLogin(@RequestParam(required = false) String error,
                              @RequestParam(required = false) String registroExitoso,
                              Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }
        if (registroExitoso != null) {
            model.addAttribute("mensaje", "Registro exitoso. Por favor inicia sesión.");
        }
        return "page/login";
    }

    // Método para redireccionar después del login exitoso
    @GetMapping("/success")
    public String loginSuccess() {
        return "redirect:/"; // Redirige al index
    }
}