package com.viamatica.springboot.Auth;

import com.viamatica.springboot.Entity.Session;
import com.viamatica.springboot.Entity.User;
import com.viamatica.springboot.JWT.JWTService;
import com.viamatica.springboot.Repository.SessionRepository;
import com.viamatica.springboot.Repository.UserRepository;
import com.viamatica.springboot.Util.ValidatorIdentification;
import com.viamatica.springboot.Util.ValidatorPassword;
import com.viamatica.springboot.Util.ValidatorUsername;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(RequestLogin requestLogin) {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestLogin.getUsername(), requestLogin.getPassword()));
            User user = userRepository.findByUsername(requestLogin.getUsername()).orElseThrow();
            System.out.println("USER SESSION ACTIVE: " + user.getSessionActive());
            if (user.getSessionActive().equals("Y")) return new AuthResponse(null, null, "User is already logged in");
            String token = jwtService.getTokenFromUser(user);
            user.setSessionActive("Y");
            userRepository.save(user);
            //Create the session for this user
            Session session = Session.builder()
                    .FechaIngreso(LocalDateTime.now())
                    .usuarios(user)
                    .build();
            sessionRepository.save(session);
            return AuthResponse.builder()
                    .token(token)
                    .user(user).build();
        } catch (AuthenticationException e) {
            throw new RuntimeException("Error de login" + e);
        }
    }

    public AuthResponse register(RequestRegister requestRegister) {
        //Username, Password, User exist and Identification validations
        if (userRepository.existsByUsername(requestRegister.getUsername()))
            return new AuthResponse(null, null, "Error: User is already registered");
        if (!ValidatorUsername.isValidUsername(requestRegister.getUsername()))
            return new AuthResponse(null, null, "Error: Username is not valid");
        if (!ValidatorPassword.isValidPassword(requestRegister.getPassword()))
            return new AuthResponse(null, null, "Error: Password is not valid");
        if (!ValidatorIdentification.isValidIdentification(requestRegister.getIdentification()))
            return new AuthResponse(null, null, "Error: Identification is not valid");
        //Create user with the requestRegister information
        User user = User.builder()
                .idUsuario(1)
                .Mail(requestRegister.getMail())
                .Password(passwordEncoder.encode(requestRegister.getPassword()))
                .username(requestRegister.getUsername())
                .build();
        userRepository.save(user);
        return new AuthResponse(user, "registered!", null);
    }

    public String logout(String authorizationHeader) {
        String token = authorizationHeader.substring("Bearer ".length());
        try {
            Claims claims = jwtService.decodeJWT(token);
            String username = claims.getSubject();
            //Change the value of SessionActive in User table
            Optional<User> userOptional = userRepository.findByUsername(username);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setSessionActive("N");
                userRepository.save(user);

                //Change the value of FechaCierre in Session table
                Optional<Session> activeSessionOptional = sessionRepository.findByUsuariosAndFechaCierreIsNull(user);
                activeSessionOptional.ifPresent(session -> {
                    session.setFechaCierre(LocalDateTime.now());
                    sessionRepository.save(session);
                });
            }


            return "Logout success!";
        } catch (Exception e) {
            // Manejar la excepción en caso de que el token no sea válido
            return "Error decoding token: " + e.getMessage();
        }
    }


}
