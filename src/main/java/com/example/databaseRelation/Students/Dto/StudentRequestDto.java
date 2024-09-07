package com.example.databaseRelation.Students.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequestDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String bio;
}
