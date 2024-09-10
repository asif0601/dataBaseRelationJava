package com.example.databaseRelation.Students.Dto;

import com.example.databaseRelation.Students.StudentEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentAddressDto {
    @NotNull
    private String pin;

    @NotNull
    private String street;

    @NotNull
    private String city;
    @NotNull
    private String country;
}
