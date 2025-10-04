package com.organization.Auto_TEC.Service;

import com.organization.Auto_TEC.Entities.usuarioEntitie;
import com.organization.Auto_TEC.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<usuarioEntitie> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<usuarioEntitie> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public usuarioEntitie save(usuarioEntitie usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<usuarioEntitie> findClientes() {
        return usuarioRepository.findByRolNombre("CLIENTE");
    }

    @Override
    public List<usuarioEntitie> findVendedores() {
        return usuarioRepository.findByRolNombre("VENDEDOR");
    }

    @Override
    public List<usuarioEntitie> findByActivoTrue() {
        return usuarioRepository.findByActivoTrue();
    }
}