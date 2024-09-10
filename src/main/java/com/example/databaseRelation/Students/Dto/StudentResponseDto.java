package com.example.databaseRelation.Students.Dto;

import com.example.databaseRelation.Students.StudentAddress;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDto {
    private String firstName;
    private String lastName;
    private String bio;
    private String day;
    private List<StudentAddressDto> address;
}
