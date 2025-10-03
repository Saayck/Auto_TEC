package com.organization.Auto_TEC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.Auto_TEC.DTO.FinanciamientoPlanDTO;
import com.organization.Auto_TEC.DTO.FinanciamientoPlanRequestDTO;
import com.organization.Auto_TEC.Service.FinanciamientoService;

@RestController
@RequestMapping("/api/financiamientos")
public class FinanciamientoController {

    @Autowired
    private FinanciamientoService financiamientoService;

    @GetMapping
    public ResponseEntity<List<FinanciamientoPlanDTO>> getAll() {
        List<FinanciamientoPlanDTO> financiamientos = financiamientoService.getAll();
        return ResponseEntity.ok(financiamientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinanciamientoPlanDTO> getById(@PathVariable Long id) {
        FinanciamientoPlanDTO financiamiento = financiamientoService.getById(id);
        if (financiamiento != null) {
            return ResponseEntity.ok(financiamiento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FinanciamientoPlanDTO> create(@RequestBody FinanciamientoPlanRequestDTO financiamientoRequest) {
        FinanciamientoPlanDTO nuevoFinanciamiento = financiamientoService.save(financiamientoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoFinanciamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinanciamientoPlanDTO> update(@PathVariable Long id, @RequestBody FinanciamientoPlanRequestDTO financiamientoRequest) {
        FinanciamientoPlanDTO financiamientoActualizado = financiamientoService.update(id, financiamientoRequest);
        if (financiamientoActualizado != null) {
            return ResponseEntity.ok(financiamientoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        FinanciamientoPlanDTO financiamiento = financiamientoService.getById(id);
        if (financiamiento != null) {
            financiamientoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}