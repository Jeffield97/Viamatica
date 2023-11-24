package com.viamatica.springboot.Auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public AuthResponse login (RequestLogin requestLogin)
    {
        return  new AuthResponse("user","login");
    }

    public AuthResponse register(RequestRegister requestRegister) {
        System.out.println(requestRegister);
        return  new AuthResponse("user","registered!");
    }
}
