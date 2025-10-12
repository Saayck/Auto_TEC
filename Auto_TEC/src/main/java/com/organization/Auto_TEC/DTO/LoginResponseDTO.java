package com.organization.Auto_TEC.DTO;

import java.time.OffsetDateTime;

public class LoginResponseDTO {
    private String sessionToken;
    private OffsetDateTime expiresAt;
    private Long userId;
    private String message;

    public LoginResponseDTO(String sessionToken, OffsetDateTime expiresAt, Long userId, String message) {
        this.sessionToken = sessionToken;
        this.expiresAt = expiresAt;
        this.userId = userId;
        this.message = message;
    }

    // Getters y setters
    public String getSessionToken() { return sessionToken; }
    public void setSessionToken(String sessionToken) { this.sessionToken = sessionToken; }
    
    public OffsetDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(OffsetDateTime expiresAt) { this.expiresAt = expiresAt; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}