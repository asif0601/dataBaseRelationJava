package com.example.databaseRelation.Security;

import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    String createAuthToken(String username);

    String getUsernameFromToken(String token) throws IllegalStateException;
}
