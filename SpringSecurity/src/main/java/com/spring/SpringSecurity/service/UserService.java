package com.spring.SpringSecurity.service;

import com.spring.SpringSecurity.entity.Users;
import com.spring.SpringSecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo  userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public Users register(Users user){
        user.setUserpassword(encoder.encode(user.getUserpassword()));
        return  userRepo.save(user);
    }

    public String verify(Users user) {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getUserpassword()));

            return authentication.isAuthenticated() ? jwtService.genetateToken(user.getUsername()) : "fail";

    }
}
