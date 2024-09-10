package com.example.databaseRelation.Students;

import com.example.databaseRelation.Students.Dto.StudentRequestDto;
import com.example.databaseRelation.Students.Dto.StudentResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(
            StudentRepository studentRepository
    ){
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto getSingleStudent(long id){
        Optional<?> savedData = studentRepository.findById(id);
        if(savedData.isPresent()){
            return StudentMapper.toStudentResponseDto((StudentEntity) savedData.get());
        }
        return null;
    }

    public StudentResponseDto saveStudentDetails(StudentRequestDto studentRequestDto){
        if(studentRequestDto == null) return null;
        StudentEntity std = StudentMapper.toStudentEntity(studentRequestDto);
        StudentEntity savedData = studentRepository.save(std);
        StudentResponseDto responseDto = StudentMapper.toStudentResponseDto(savedData);
        return responseDto;
    }

    public List<?> getAllStudentDetails(int pageNumber, int pageSize){
        PageRequest pageRequest =  PageRequest.of(pageNumber, pageSize);
        Page<StudentEntity> pagePost = studentRepository.findAll(pageRequest);
        List<StudentEntity> allStudent = pagePost.getContent();
        return allStudent;
    }

    public StudentResponseDto updateStudentDetails(Long id, StudentRequestDto studentRequestDto){
        Optional<?> stdSavedData = studentRepository.findById(id);
        if(stdSavedData.isPresent()){
            StudentEntity stdEntity = StudentMapper.toStudentEntity(studentRequestDto);
            stdEntity.setStudentId(id);
            StudentEntity res = studentRepository.save(stdEntity);
            StudentResponseDto responseDto = StudentMapper.toStudentResponseDto(res);
            return responseDto;
        } else{
            throw new IllegalArgumentException(id+ " Not exist");
        }
    }

    public Boolean deleteStudentById(int id){
        Optional<?> details = studentRepository.findById((long) id);
        if(details.isPresent()){
            studentRepository.delete((StudentEntity) details.get());
            return true;
        }
        throw new IllegalArgumentException("student with id: "+id + " not exist");
    }

}
