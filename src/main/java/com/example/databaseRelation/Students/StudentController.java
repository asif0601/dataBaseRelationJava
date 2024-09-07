package com.example.databaseRelation.Students;

import com.example.databaseRelation.Students.Dto.StudentRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class StudentController {

    @PostMapping("student")
    public ResponseEntity<?> getListOfStudents(@Valid @RequestBody StudentRequestDto studentRequestDto){

        return ResponseEntity.status(HttpStatus.OK).body("reached here");
    }

}
