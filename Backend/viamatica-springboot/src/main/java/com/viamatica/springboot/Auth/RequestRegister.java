package com.viamatica.springboot.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestRegister {
    private String username;
    private String names;
    private String lastnames;
    private String identification;
    private Date birthdate;
    private String password;

    public String getMail() {
        return this.username+"@gmail.com";
    }
}
