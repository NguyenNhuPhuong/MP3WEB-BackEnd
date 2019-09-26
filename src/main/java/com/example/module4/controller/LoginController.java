package com.example.module4.controller;


import com.example.module4.message.LoginForm;
import com.example.module4.message.response.JwtResponse;
import com.example.module4.repository.UserRepository;
import com.example.module4.service.jwt.JwtTokenProvider;
import com.example.module4.service.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginForm) {
        JwtResponse output = new JwtResponse();
        try {
            Authentication authen = new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword());
                Authentication authentication = authenticationManager.authenticate(authen);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateJwtToken(authentication);
            return ResponseEntity.ok(new JwtResponse(jwt, (UserDetailsImpl)authentication.getPrincipal()));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        output.setCode(422);
        output.setMessage("error: user or pass not true");
        return ResponseEntity.ok(output);
    }
}
