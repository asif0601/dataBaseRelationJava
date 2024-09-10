package com.example.databaseRelation.Students;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class StudentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    private String pin;

    @NotNull
    private String street;

    @NotNull
    private String city;
    @NotNull
    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private StudentEntity studentEntity;
}
