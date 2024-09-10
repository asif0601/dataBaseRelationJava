package com.example.databaseRelation.Students.Helper;

import com.example.databaseRelation.Students.Dto.StudentRequestDto;
import com.example.databaseRelation.Students.StudentEntity;

public interface AddressMapper {
    public void dtoToStudentAddressEntity(StudentRequestDto studentRequestDto);
    public void entityToStudentAddressResponseDto(StudentEntity studentEntity);
}
