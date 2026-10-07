package com.springjpa.SpringDataJpa.controller;

import com.springjpa.SpringDataJpa.entity.Profile;
import com.springjpa.SpringDataJpa.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> findAllProfiles(){
        return profileService.findAllProfiles();
    }

    @GetMapping("/{profileId}")
    public Profile findProfileById(@PathVariable Long profileId){
        return  profileService.findProfileById(profileId);
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile){
        return profileService.createProfile(profile);
    }

    @PutMapping("/{profileId}")
    public Profile updateProfile(@RequestBody Profile profile, @PathVariable Long profileId){
        Profile oldProfile = profileService.findProfileById(profileId);
        if(oldProfile != null){
            oldProfile.setBio(profile.getBio()!=null && !profile.getBio().equals("")?profile.getBio():oldProfile.getBio());
            oldProfile.setPhoneNumber(profile.getPhoneNumber()!=null?profile.getPhoneNumber():oldProfile.getPhoneNumber());
            return  profileService.updateProfile(oldProfile);
        }
        return null;
    }

    @DeleteMapping("/{profileId}")
    public void deleteProfile(@PathVariable Long profileId){
        profileService.deleteProfileById(profileId);
    }
}
