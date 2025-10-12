package com.organization.Auto_TEC.DTO;

public class LoginRequestDTO {
    private String usernameOrEmail;
    private String password;
    private boolean kickPrevious = false;

    // Getters y setters
    public String getUsernameOrEmail() { return usernameOrEmail; }
    public void setUsernameOrEmail(String usernameOrEmail) { this.usernameOrEmail = usernameOrEmail; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public boolean isKickPrevious() { return kickPrevious; }
    public void setKickPrevious(boolean kickPrevious) { this.kickPrevious = kickPrevious; }
}