package com.example.databaseRelation.Tokens;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.databaseRelation.Security.TokenService;
import com.example.databaseRelation.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class UserTokenService implements TokenService {

    private final UserTokenRepository userTokenRepository;

    private final UsersRepository usersRepository;

    public UserTokenService(
            @Autowired UserTokenRepository userTokenRepository,
            @Autowired UsersRepository usersRepository
    ){
        this.userTokenRepository = userTokenRepository;
        this.usersRepository = usersRepository;
    }


    @Override
    public String createAuthToken(String username) {
        var user = usersRepository.findByUsername(username);
        var token = userTokenRepository.save(UserTokenEntity.builder()
                .user(user)
                .expiryDate(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 20))
                .build()
        );
        return token.getId().toString();
    }

    @Override
    public String getUsernameFromToken(String token) throws IllegalStateException {

        var saved  = userTokenRepository.findById(UUID.fromString(token));
        if(saved.isPresent()){
            var user = saved.get().getUser();
            if(user != null){
                return user.getUsername();
            }
        }

        return null;
    }
}
