package com.inovationlab.businessinfo.dto;

public class LoginResponseDto {
    private String username;
    private String accessToken;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String username, String accessToken) {
        this.accessToken = accessToken;
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
