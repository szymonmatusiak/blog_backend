package com.example.blog.config;

import io.jsonwebtoken.SignatureAlgorithm;

public class SecurityConstants {

    public static final String SECRET_64_BYTE = "J@McQfTjWnZr4u7x!A%D*G-KaPdRgUkXp2s5v8y/B?E(H+MbQeThVmYq3t6w9z$C";
    public static final byte[] SECRET_BYTES = SECRET_64_BYTE.getBytes();
    public static final long EXPIRATION_TIME = 864_000_000;// ms =  10days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORITIES_CLAIM_KEY = "Authorization";
    public static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS512;
    public static final String REGISTRATION_URL = "api2/user";
    public static final String LOGIN_URL = "/login";
}
