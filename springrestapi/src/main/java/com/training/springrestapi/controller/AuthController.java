package com.training.springrestapi.controller;

import com.training.springrestapi.dao.UserRepository;
import com.training.springrestapi.dto.AuthenticationRequestDTO;
import com.training.springrestapi.dto.AuthenticationResponseDTO;
import com.training.springrestapi.dto.UserDTO;
import com.training.springrestapi.entity.User;
import com.training.springrestapi.service.UserService;
import com.training.springrestapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/auth")

public class AuthController {

    @Autowired

    private AuthenticationManager authenticationManager;

    @Autowired

    private JwtUtil jwtUtil;


    @Autowired
    private UserService userService;

    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDTO request) {



            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword())
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String role = userDetails.getAuthorities()
                    .iterator()
                    .next()
                    .getAuthority();

            String token = jwtUtil.generateToken(userDetails.getUsername(), role);

            return ResponseEntity.ok(new AuthenticationResponseDTO(token));
        }



//http:localhost:8080/api/auth/register
    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO user)
    {
        return userService.registerUser(user);
    }

}






