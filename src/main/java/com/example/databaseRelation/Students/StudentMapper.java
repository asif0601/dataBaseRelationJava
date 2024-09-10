package com.example.databaseRelation.Students;

import com.example.databaseRelation.Students.Dto.StudentAddressDto;
import com.example.databaseRelation.Students.Dto.StudentRequestDto;
import com.example.databaseRelation.Students.Dto.StudentResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    public static StudentAddress toAddressMapper(StudentAddressDto studentAddress){
        StudentAddress std = new StudentAddress();
        std.setPin(studentAddress.getPin());
        std.setCity(studentAddress.getCity());
        std.setCountry(studentAddress.getCountry());
        std.setStreet(studentAddress.getStreet());
        return std;
    }
    public static StudentAddressDto toAddressDtoMapper(StudentAddress studentAddress){
        StudentAddressDto std = new StudentAddressDto();
        std.setPin(studentAddress.getPin());
        std.setCity(studentAddress.getCity());
        std.setCountry(studentAddress.getCountry());
        std.setStreet(studentAddress.getStreet());
        return std;
    }
    public static StudentEntity toStudentEntity(StudentRequestDto dto){
        if(dto == null){
            return null;
        }
        StudentEntity resp = new StudentEntity();
        resp.setFirstName(dto.getFirstName());
        resp.setLastName(dto.getLastName());
        resp.setBio(dto.getBio());
        resp.setDay(dto.getDay());
        resp.setAddress(
                dto.getAddress().stream()
                        .map(item -> StudentMapper.toAddressMapper(item))
                        .collect(Collectors.toList()));
        return resp;
    }
    public static StudentResponseDto toStudentResponseDto(StudentEntity stdEn){
        if(stdEn == null) return null;
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setFirstName(stdEn.getFirstName());
        responseDto.setLastName(stdEn.getLastName());
        responseDto.setBio(stdEn.getBio());
        responseDto.setDay(String.valueOf(stdEn.getDay()));
        responseDto.setAddress(
                stdEn.getAddress().stream()
                        .map(item -> toAddressDtoMapper(item))
                        .collect(Collectors.toList())
        );
        return responseDto;
    }
}
