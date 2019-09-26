package com.example.module4.message.response;

import com.example.module4.service.security.UserDetailsImpl;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private String message ;
    private int code;

    public Long getId() {
        return id ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, UserDetailsImpl userDetails) {
        this.id = userDetails.getId();
        this.token = accessToken;
        this.username = userDetails.getUsername();
        this.code = 200;
        this.message = "success";
        this.roles = userDetails.getRoles();
    }

    public JwtResponse() {
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }
}
