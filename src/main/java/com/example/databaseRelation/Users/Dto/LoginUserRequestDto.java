package com.example.databaseRelation.Users.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class LoginUserRequestDto {

    @NotNull
    String username;
    @NotNull
    String password;
}
