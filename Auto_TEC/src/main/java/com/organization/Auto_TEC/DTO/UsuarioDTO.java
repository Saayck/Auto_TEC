package com.organization.Auto_TEC.DTO;

import java.time.OffsetDateTime;

public class UsuarioDTO {
    private Long id;
    private Long rolId;
    private String rolNombre;
    private Long departamentoId;
    private String departamentoNombre;
    private String username;
    private String email;
    private String nombres;
    private String apellidos;
    private boolean activo;
    private OffsetDateTime fechaRegistro;
    private OffsetDateTime ultimoLogin;

    // Constructor vacío
    public UsuarioDTO() {}

    // Constructor con todos los campos
    public UsuarioDTO(Long id, Long rolId, String rolNombre, Long departamentoId, String departamentoNombre,
                     String username, String email, String nombres, String apellidos, boolean activo,
                     OffsetDateTime fechaRegistro, OffsetDateTime ultimoLogin) {
        this.id = id;
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.departamentoId = departamentoId;
        this.departamentoNombre = departamentoNombre;
        this.username = username;
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
        this.ultimoLogin = ultimoLogin;
    }

    // Constructor desde la entidad - CORREGIDO
    public static UsuarioDTO fromEntity(com.organization.Auto_TEC.Entities.usuarioEntitie entity) {
        Long rolId = entity.getRol() != null ? entity.getRol().getId() : null;
        String rolNombre = entity.getRol() != null ? entity.getRol().getNombre() : null;
        
        Long departamentoId = entity.getDepartamentos() != null ? entity.getDepartamentos().getId() : null;
        String departamentoNombre = entity.getDepartamentos() != null ? entity.getDepartamentos().getNombre() : null;

        return new UsuarioDTO(
            entity.getId(),
            rolId,
            rolNombre,
            departamentoId,
            departamentoNombre,
            entity.getUsername(),
            entity.getEmail(),
            entity.getNombres(),
            entity.getApellidos(),
            entity.isActivo(),
            entity.getFechaRegistro(),
            entity.getUltimoLogin()
        );
    }

    // Resto de constructores, getters y setters se mantienen igual...
    // Constructor para creación (sin ID ni fechas)
    public UsuarioDTO(Long rolId, Long departamentoId, String username, String email, 
                     String nombres, String apellidos, boolean activo) {
        this.rolId = rolId;
        this.departamentoId = departamentoId;
        this.username = username;
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.activo = activo;
    }

    // Getters y Setters (se mantienen igual)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public OffsetDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(OffsetDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public OffsetDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(OffsetDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    // Método para obtener nombre completo
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }
}