package com.viamatica.springboot.Auth;

import com.viamatica.springboot.Entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthResponse {
    private User user ;
    private String token;
    private String error;
}
