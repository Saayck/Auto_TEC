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

  @Bean
  public AuthenticationProvider authenticationProvider(
      @Qualifier("adminUserDetailsService") UserDetailsService uds,
      PasswordEncoder pe
  ) {
    DaoAuthenticationProvider p = new DaoAuthenticationProvider();
    p.setUserDetailsService(uds);
    p.setPasswordEncoder(pe);
    return p;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

  // Success handler que audita y redirige a /dashboard
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
          .requestMatchers("/css/**","/js/**","/images/**").permitAll()
          .requestMatchers("/","/animacion", "/index", "/contacto","/gestion",
                           "/login","/modelos","/registro","/servicios","/ventas","/financiamiento").permitAll()
          .requestMatchers("/dashboard").hasRole("ADMIN")  
          .requestMatchers("/admin/**").hasRole("ADMIN")
          .anyRequest().authenticated()
      )
      .formLogin(form -> form
          .loginPage("/login")
          .loginProcessingUrl("/login")
          .usernameParameter("email")
          .passwordParameter("password")  
          .successHandler(adminLoginSuccessHandler) 
          .failureUrl("/login?error")
          .permitAll()
      )
      .logout(l -> l.logoutUrl("/logout").logoutSuccessUrl("/login?logout"));
    return http.build();
  }
}
