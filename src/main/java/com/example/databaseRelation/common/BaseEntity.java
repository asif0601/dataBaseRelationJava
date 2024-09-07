package com.example.databaseRelation.common;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter(AccessLevel.PUBLIC)
public abstract class BaseEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    UUID id;

    @CreationTimestamp
    Date createdAt;
}
