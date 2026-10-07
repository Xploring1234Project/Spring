package com.springjpa.SpringDataJpa.service;

import com.springjpa.SpringDataJpa.entity.Profile;
import com.springjpa.SpringDataJpa.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepo;

    public List<Profile> findAllProfiles(){
        return profileRepo.findAll();
    }

    public Profile findProfileById(Long id){
        return profileRepo.findById(id).get();
    }

    public Profile createProfile(Profile profile){
        return profileRepo.save(profile);
    }

    public Profile updateProfile(Profile profile){
        return profileRepo.save(profile);
    }

    public void deleteProfileById(Long id){
        profileRepo.deleteById(id);
    }

}
