package com.example.databaseRelation.Students.Dto;

import com.example.databaseRelation.Students.common.Day;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class StudentRequestDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String bio;

    @Valid
    private List<StudentAddressDto> address;

    @NotNull
    private Day day;
}
