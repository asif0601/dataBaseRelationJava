package com.example.databaseRelation.Users;

import com.example.databaseRelation.Security.TokenService;
import com.example.databaseRelation.Users.Dto.CreateUserRequestDto;
import com.example.databaseRelation.Users.Dto.LoginUserRequestDto;
import com.example.databaseRelation.Users.Dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    private final UsersService usersService;
    private final TokenService tokenService;

    private final ModelMapper modelMapper;

    public UsersController(
            @Autowired UsersService usersService,
            @Autowired TokenService tokenService,
            @Autowired ModelMapper modelMapper
    ){
        this.usersService = usersService;
        this.tokenService = tokenService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("sign-up")
    public ResponseEntity<?> signUpUsers(@Valid @RequestBody CreateUserRequestDto userRequestDto){

        var savedUser = usersService.signUpUser(userRequestDto);
        var userResp = modelMapper.map(savedUser, UserResponseDto.class);
        return ResponseEntity.status((HttpStatus.OK)).body(userResp);
    }

    @PostMapping("login")
    public ResponseEntity<UserResponseDto> loginUsers(@Valid @RequestBody LoginUserRequestDto loginUserRequestDto){
        var savedUser = usersService.loginUser(
                loginUserRequestDto.getUsername(),
                loginUserRequestDto.getPassword()
        );
        var userResp = modelMapper.map(savedUser, UserResponseDto.class);
        savedUser.getId();
        var token = tokenService.createAuthToken(loginUserRequestDto.getUsername());
        userResp.setToken(token);
        log.info("user not found");

        return ResponseEntity.status(HttpStatus.OK).body(userResp);
    }
}
