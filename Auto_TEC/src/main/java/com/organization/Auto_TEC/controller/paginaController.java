package com.organization.Auto_TEC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;


@Controller

public class paginaController {
   private static final String[] PAGE = {"index","contacto","gestion","login","modelos","registro","servicios","ventas", "financiamiento"};
   private static final String[] ADMIN = {"dashboard","gestion_autos","gestion_citas","gestion_clientes","gestion_empleados","gestion_solicitudes","gestion_ventas","reportes"};
     @GetMapping("/")
    public String Principal() {
        return "page/animacion";
    }
    @GetMapping("/{view}")
    public String page(@PathVariable String view) {
        for (String p : PAGE) {
            if (p.equals(view)) return "page/" + view;
        }
        for (String a : ADMIN) {
            if(a.equals(view)) return "admin/" +view;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}



