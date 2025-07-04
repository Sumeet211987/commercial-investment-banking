package com.cib.auth.constants;


public class SecurityConstants {

    public static final String JWT_SECRET = "your-very-secure-secret-key"; 
    public static final long JWT_EXPIRATION_TIME = 1000 * 60 * 60; // 60 minutes
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String[] PUBLIC_ENDPOINTS = {
        "/api/auth/login",
        "/api/auth/refresh",
        "/api/auth/logout"
    };
    public static final String[] AUTHENTICATED_ENDPOINTS = {
    	    "/api/auth/roles/**"  
    	};
}
