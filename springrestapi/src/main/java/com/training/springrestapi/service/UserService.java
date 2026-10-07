package com.training.springrestapi.service;

import com.training.springrestapi.dao.UserRepository;
import com.training.springrestapi.dto.UserDTO;
import com.training.springrestapi.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public User registerUser(UserDTO userDto) {

        User user = modelMapper.map(userDto,User.class);

       // user.setUsername(userDto.getUsername());
        //user.setRole("ROLE_USER");
        // Encrypt password
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);

    }
}


