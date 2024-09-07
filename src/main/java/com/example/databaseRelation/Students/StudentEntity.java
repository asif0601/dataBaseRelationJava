package com.example.databaseRelation.Students;

import com.example.databaseRelation.Users.Dto.LoginUserRequestDto;
import com.example.databaseRelation.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "student")
public class StudentEntity extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long studentId;

    private String firstName;

    private String lastName;

    private String bio;
}
