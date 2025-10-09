package com.organization.Auto_TEC.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.organization.Auto_TEC.Repository.AdministradorRepository;

@Configuration
public class SecurityConfig {

    private final UserDetailsService adminUserDetailsService;

    // Que sepa aqui falto el inyectar el AdminUserDetailsService
    public SecurityConfig(@Qualifier("adminUserDetailsService") UserDetailsService adminUserDetailsService) {
        this.adminUserDetailsService = adminUserDetailsService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(PasswordEncoder pe) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(adminUserDetailsService);
        provider.setPasswordEncoder(pe);
        provider.setHideUserNotFoundExceptions(false); 
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationSuccessHandler adminLoginSuccessHandler(AdministradorRepository adminRepo) {
        return new AdminLoginSuccessHandler(adminRepo, "/dashboard");
    }

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            AuthenticationProvider provider,
            AuthenticationSuccessHandler adminLoginSuccessHandler
    ) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authenticationProvider(provider)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                .requestMatchers("/", "/animacion", "/index", "/contacto", "/gestion",
                               "/login", "/modelos", "/registro", "/servicios", 
                               "/ventas", "/financiamiento", "/error").permitAll()
                .requestMatchers("/dashboard", "/admin/**").hasRole("ADMIN")  
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("email")  // Asegúrate que coincida con tu HTML
                .passwordParameter("password")  
                .successHandler(adminLoginSuccessHandler) 
                .failureUrl("/login?error=true") // Mejorado para debugging
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .exceptionHandling(exceptions -> exceptions
                .accessDeniedPage("/login?accessDenied=true")
            );

        return http.build();
    }
}