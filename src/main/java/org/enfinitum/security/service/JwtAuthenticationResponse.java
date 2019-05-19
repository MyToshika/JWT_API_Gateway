package org.enfinitum.security.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationResponse implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String token;


    public void setToken(String token) {
		this.token = token;
	}


	public String getToken() {
        return this.token;
    }
}
