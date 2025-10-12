package com.organization.Auto_TEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.organization.Auto_TEC.DTO.RegistroDTO;
import com.organization.Auto_TEC.Service.UsuarioService;

@Controller
@RequestMapping("/auth")
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registroDTO", new RegistroDTO());
        return "page/registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute RegistroDTO registroDTO, Model model) {
        try {
            usuarioService.registrarUsuario(registroDTO);
            return "redirect:/auth/login?registroExitoso=true"; // ← Asegúrate que sea /auth/login
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("registroDTO", registroDTO);
            return "page/registro";
        }
    }
}