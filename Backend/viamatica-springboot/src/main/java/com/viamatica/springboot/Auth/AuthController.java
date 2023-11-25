package com.viamatica.springboot.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
    final private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody RequestLogin requestLogin) {
        return authService.login(requestLogin);
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RequestRegister requestRegister) {
        return authService.register(requestRegister);
    }

    @GetMapping("/logout")
    public  LogoutResponse logout(@RequestHeader("Authorization") String authorizationHeader)
    {
        return authService.logout(authorizationHeader);
    }

}
