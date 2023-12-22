package com.scaler.BlogapiApplication.users.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserResponseDto {
    @NonNull
    String username;
    @NonNull
    String email;
    @NonNull
    String bio;

    String token;
}
