package com.springdto.SpringDTO.service;

import com.springdto.SpringDTO.dto.UserLocationDTO;
import com.springdto.SpringDTO.model.User;
import com.springdto.SpringDTO.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserLocationDTO> getAllUserLocations(){
        return userRepository.findAll()
                .stream()
                .map(item->convertEntityToDTO(item)) //map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    /*private UserLocationDTO convertEntityToDTO(User user){
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        return userLocationDTO;
    }*/

    private UserLocationDTO convertEntityToDTO(User user){
        return modelMapper.map(user,UserLocationDTO.class);
    }




}
