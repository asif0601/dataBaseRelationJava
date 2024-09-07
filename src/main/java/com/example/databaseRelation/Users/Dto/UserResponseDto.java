package com.example.databaseRelation.Users.Dto;

import jakarta.annotation.Nullable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserResponseDto {
    @NonNull
    String username;
    @NonNull
    String email;
    @Nullable
    String bio;

    String token;
}
