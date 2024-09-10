package com.example.databaseRelation.Students;

import com.example.databaseRelation.Students.Dto.StudentRequestDto;
import com.example.databaseRelation.Students.Dto.StudentResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class StudentController {
    private StudentService studentService;

    public StudentController(
            StudentService studentService
    ){
        this.studentService = studentService;
    }

    @PostMapping("student")
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto responseDto = studentService.saveStudentDetails(studentRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("student")
    public ResponseEntity<?> getAllStudent(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "2", required = false) int pageSize
    ){
        List<?> resp = studentService.getAllStudentDetails(pageNumber, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<?> getSingleStudent(@PathVariable("id") long id){
        StudentResponseDto std = studentService.getSingleStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(std);
    }

    @PutMapping("student/{id}")
    public ResponseEntity<?> updateStudentDetails(
            @RequestBody StudentRequestDto studentRequestDto,
            @PathVariable("id") Long id
    ){
        StudentResponseDto responseDto = studentService.updateStudentDetails(id, studentRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<Boolean> studentDetialsDeleted(@PathVariable("id") int id){
        Boolean b = studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

}
