package com.viamatica.springboot.Auth;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthResponse {
    private String user ;
    private String token;
}
