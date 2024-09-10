package com.example.databaseRelation.Students;

import com.example.databaseRelation.Students.common.Day;
import com.example.databaseRelation.Users.Dto.LoginUserRequestDto;
import com.example.databaseRelation.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "student")
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String firstName;

    private String lastName;

    private String bio;

    private Day day;

    @OneToMany(mappedBy = "studentEntity", fetch=FetchType.EAGER )
    private List<StudentAddress> address = new ArrayList<>();
}
