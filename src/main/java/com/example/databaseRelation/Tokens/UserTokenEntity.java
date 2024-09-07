package com.example.databaseRelation.Tokens;

import com.example.databaseRelation.Users.UserEntity;
import com.example.databaseRelation.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Entity(name = "user_tokens")
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Builder
@RequiredArgsConstructor
public class UserTokenEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    Date expiryDate;
}
