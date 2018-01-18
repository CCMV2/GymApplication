package com.ubb.gymapp.security;

import java.io.Serializable;

/**
 * Created by stephan on 20.03.16.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final String role;
    private final long start;
    private final Long id;

    public JwtAuthenticationResponse(String token, String role, long start, Long id) {
        this.token = token;
        this.role = role;
        this.start = start;
        this.id = id;
    }

    public String getToken() {
        return this.token;
    }
    
    public String getRole() {
    	return this.role;
    }

	public long getStart() {
		return start;
	}

	public Long getId() {
		return id;
	}
}
