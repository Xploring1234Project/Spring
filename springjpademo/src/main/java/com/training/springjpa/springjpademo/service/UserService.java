package com.training.springjpa.springjpademo.service;

import com.training.springjpa.springjpademo.dao.AddressRepository;
import com.training.springjpa.springjpademo.dao.UserRepository;
import com.training.springjpa.springjpademo.model.Address;
import com.training.springjpa.springjpademo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AddressRepository addressRepo;

    public User addUser(User u)
    {
        return userRepo.save(u);
    }

    public User updateUserAddress(Long userId) {

        User user = userRepo.findById(userId).orElse(null);

        if (user != null) {

            Address address = user.getAddress();
            address.setCity("Coimbatore");
            userRepo.save(user);
        }
        return user;
    }
    public void deleteUser(Long id)
    {
        //userRepo.deleteById(id);
        User user=userRepo.findById(id).get();
        user.setAddress(null);
        userRepo.save(user);
        //addressrepo.deletebyid
    }

    public User findUserAddress(long l) {
        User user=userRepo.findById(l).get();
        return user;

    }

    public Address findAddressUser(long l) {
        Address address=addressRepo.findById(l).get();
        return address;
    }
}
