package com.organization.Auto_TEC.Service;

import java.util.List;
import java.util.Optional;

import com.organization.Auto_TEC.Entities.usuarioEntitie;

public interface UsuarioService {
    List<usuarioEntitie> findAll();
    Optional<usuarioEntitie> findById(Long id);
    usuarioEntitie save(usuarioEntitie usuario);
    void deleteById(Long id);
    List<usuarioEntitie> findClientes(); // Usuarios con rol CLIENTE
    List<usuarioEntitie> findVendedores(); // Usuarios con rol VENDEDOR
    List<usuarioEntitie> findByActivoTrue();
}