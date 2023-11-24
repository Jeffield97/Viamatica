package com.viamatica.springboot.Auth;

import lombok.Data;

@Data
public class RequestLogin {
    private String username;
    private String password;

}
