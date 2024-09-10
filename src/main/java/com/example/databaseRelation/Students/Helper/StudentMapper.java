package com.example.databaseRelation.Students.Helper;

import com.example.databaseRelation.Students.Dto.StudentRequestDto;
import com.example.databaseRelation.Students.StudentEntity;

public interface StudentMapper {

    public void dtoToStudentEntity(StudentRequestDto studentRequestDto);
    public void entityToStudentResponseDto(StudentEntity studentEntity);
}
