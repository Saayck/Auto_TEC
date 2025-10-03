package com.organization.Auto_TEC.Config;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.organization.Auto_TEC.Entities.administradorEntitie;
import com.organization.Auto_TEC.Repository.AdministradorRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final AdministradorRepository adminRepo;

    public AdminLoginSuccessHandler(AdministradorRepository adminRepo, String defaultTargetUrl) {
        this.adminRepo = adminRepo;
        setDefaultTargetUrl(defaultTargetUrl);
        setAlwaysUseDefaultTargetUrl(true); 
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        Object principal = authentication.getPrincipal();
        String login = (principal instanceof User u) ? u.getUsername() : authentication.getName();

        Optional<administradorEntitie> opt = adminRepo.findByUsernameOrEmail(login, login);
        if (opt.isPresent()) {
            administradorEntitie admin = opt.get();
            try {
                admin.setUltimoLogin(OffsetDateTime.now());
                admin.setUltimoIp(request.getRemoteAddr());
                admin.setUltimoUserAgent(request.getHeader("User-Agent"));
                adminRepo.save(admin);
            } catch (Exception ignored) {
            }
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
