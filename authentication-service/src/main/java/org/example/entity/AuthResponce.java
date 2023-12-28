package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponce {

    private String accessToken;
    private String refreshToken;
}
