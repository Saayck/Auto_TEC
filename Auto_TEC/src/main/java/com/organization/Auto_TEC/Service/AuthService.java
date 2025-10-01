package com.organization.Auto_TEC.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.Auto_TEC.DTO.LoginResponseDTO;
import com.organization.Auto_TEC.Entities.Sesiones;
import com.organization.Auto_TEC.Entities.usuarioEntitie;
import com.organization.Auto_TEC.Repository.SesionRepository;
import com.organization.Auto_TEC.Repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepo;
    private final SesionRepository sesionRepo;

    public AuthService(UsuarioRepository usuarioRepo, SesionRepository sesionRepo) {
        this.usuarioRepo = usuarioRepo;
        this.sesionRepo = sesionRepo;
    }

    @Transactional
    public LoginResponseDTO loginSoloUnaSesion(String usernameOrEmail, String rawPassword, boolean kickPrevious, String ip, String userAgent) {
        
        //buscas usuario
        usuarioEntitie user = usuarioRepo
                .findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

     
        //revisar si existe sesión activa
        Optional<Sesiones> actual = sesionRepo.findFirstByUsuario_IdAndActivaTrue(user.getId());
        if (actual.isPresent()) {
            Sesiones s = actual.get();
            if (s.getFechaExpiracion().isAfter(OffsetDateTime.now())) {
                if (!kickPrevious) {
                    return new LoginResponseDTO(
                            null,
                            s.getFechaExpiracion(),
                            user.getId(),
                            "Ya tienes una sesión activa."
                    );
                } else {
                    s.setActiva(false);
                    s.setFechaCreacion(OffsetDateTime.now());
                    sesionRepo.save(s);
                }
            } else {
                s.setActiva(false);
                s.setFechaCreacion(OffsetDateTime.now());
                sesionRepo.save(s);
            }
        }

        //crear nueva sesión
        OffsetDateTime ahora = OffsetDateTime.now();
        Sesiones nueva = new Sesiones();
        nueva.setUsuario(user);
        nueva.setSessionToken(UUID.randomUUID().toString());
        nueva.setFechaCreacion(ahora);
        nueva.setFechaExpiracion(ahora.plusHours(1));
        nueva.setActiva(true);
        nueva.setIpAddress(ip);
        nueva.setUserAgent(userAgent);

        try {
            sesionRepo.save(nueva);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Ya existe una sesión activa para este usuario.", e);
        }

        user.setUltimoLogin(ahora);
        usuarioRepo.save(user);

        return new LoginResponseDTO(
                nueva.getSessionToken(),
                nueva.getFechaExpiracion(),
                user.getId(),
                "Login correcto"
        );
    }
}
