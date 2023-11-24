package com.viamatica.springboot.Auth;

import com.viamatica.springboot.Entity.User;
import com.viamatica.springboot.JWT.JWTService;
import com.viamatica.springboot.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    public AuthResponse login (RequestLogin requestLogin)
    {
        try {
            System.out.println("USERNAME: "+requestLogin.getPassword() + requestLogin.getUsername());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestLogin.getUsername(), requestLogin.getPassword()));
            User user = userRepository.findByUsername(requestLogin.getUsername()).orElseThrow();
            String token = jwtService.getTokenFromUser(user);

            return AuthResponse.builder()
                    .token(token)
                    .user(user).build();
        } catch (AuthenticationException e) {
            throw new RuntimeException("Error de login"+e);
        }
    }

    public AuthResponse register(RequestRegister requestRegister) {
        if(userRepository.existsByUsername(requestRegister.getUsername()))
        {
            return new AuthResponse(null,null,"Error: User is already registered");
        }
        User user = User.builder()
                .idUsuario(1)
                .Mail(requestRegister.getMail())
                .Password(passwordEncoder.encode(requestRegister.getPassword()))
                .username(requestRegister.getUsername())
                .build();
        System.out.println(user);
        userRepository.save(user);
        return  new AuthResponse(user,"registered!",null);
    }
}
