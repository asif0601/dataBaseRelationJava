package com.example.databaseRelation.Users;

import com.example.databaseRelation.GlobalErrorHandle.UserAlreadyExistsException;
import com.example.databaseRelation.Users.Dto.CreateUserRequestDto;
import com.example.databaseRelation.Users.Dto.UserResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

    public UsersService(@Autowired UsersRepository usersRepository, @Autowired PasswordEncoder passwordEncoder){
        this.usersRepository = usersRepository;
        this.passwordEncoder  = passwordEncoder;
    }



    public UserEntity loginUser(String username, String password){

        try{
            var savedUser = usersRepository.findByUsername(username);

            if(savedUser != null){
                if (passwordEncoder.matches(password, savedUser.getPassword())){
                    return savedUser;
                } else {
                    logger.info("user not found");
                    throw new IllegalArgumentException("username and password are in correct");
                }
            } else{
                logger.info("password is in-correct for {} : ", username);
                logger.warn("password is in-correct");
                logger.error("password is in-correct");
                throw new IllegalArgumentException("user not found");
            }
        }catch(IllegalArgumentException ex){
            throw new IllegalArgumentException("user not found");
        }
    }

    public UserEntity signUpUser(CreateUserRequestDto userRequestDto){

        try{
            var savedUser = usersRepository.save(
                    UserEntity
                            .builder()
                            .username(userRequestDto.getUsername())
                            .password(passwordEncoder.encode(userRequestDto.getPassword()))
                            .email(userRequestDto.getEmail())
                            .build()
            );
            return savedUser;
        }catch(DataIntegrityViolationException dataIntegrityViolationException){
            throw new UserAlreadyExistsException("Username or email already exists");
        }

    }
}
