package com.example.databaseRelation.Users.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequestDto {

    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;

    private String bio;
}
