package com.ubb.gymapp.security;

import java.io.Serializable;

/**
 * Created by stephan on 20.03.16.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final String role;

    public JwtAuthenticationResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return this.token;
    }
    
    public String getRole() {
    	return this.role;
    }
}
