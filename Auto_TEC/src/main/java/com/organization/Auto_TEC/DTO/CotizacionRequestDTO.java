package com.organization.Auto_TEC.DTO;

// DTO para creación/actualizacion de cotizaciones

public class CotizacionRequestDTO {
    private Long usuarioId;
    private Long modeloId;
    private String nombreSolicitante;
    private String emailSolicitante;
    private String modeloInteres;
    private String notas;

    // Constructores
    public CotizacionRequestDTO() {}

    public CotizacionRequestDTO(Long usuarioId, Long modeloId, String nombreSolicitante, 
                               String emailSolicitante, String modeloInteres, String notas) {
        this.usuarioId = usuarioId;
        this.modeloId = modeloId;
        this.nombreSolicitante = nombreSolicitante;
        this.emailSolicitante = emailSolicitante;
        this.modeloInteres = modeloInteres;
        this.notas = notas;
    }

    // Getters y Setters
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }

    public String getNombreSolicitante() { return nombreSolicitante; }
    public void setNombreSolicitante(String nombreSolicitante) { this.nombreSolicitante = nombreSolicitante; }

    public String getEmailSolicitante() { return emailSolicitante; }
    public void setEmailSolicitante(String emailSolicitante) { this.emailSolicitante = emailSolicitante; }

    public String getModeloInteres() { return modeloInteres; }
    public void setModeloInteres(String modeloInteres) { this.modeloInteres = modeloInteres; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}