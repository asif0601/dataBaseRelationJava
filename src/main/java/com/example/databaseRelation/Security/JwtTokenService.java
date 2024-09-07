package com.example.databaseRelation.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenService implements TokenService{

    private final Algorithm algorithm;

    private final String secret_key = "1234567890";
    private final  Long time = (long) 100 * 60 * 60;
    private final String issuer = "blog api";

    public JwtTokenService() {
        this.algorithm = Algorithm.HMAC256(secret_key);
    }


    @Override
    public String createAuthToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer(issuer)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date( System.currentTimeMillis() + time) )
                .sign(algorithm);
    }

    @Override
    public String getUsernameFromToken(String token) throws IllegalStateException {
        var verifier = JWT
                .require(algorithm)
                .withIssuer(issuer)
                .build();
        var decodeToken = verifier.verify(token);
        return decodeToken.getSubject();
    }
}
