package com.springpractise.MyPractise.service;


import com.springpractise.MyPractise.entity.JournalEntry;
import com.springpractise.MyPractise.entity.User;
import com.springpractise.MyPractise.repository.JournalEntryRepository;
import com.springpractise.MyPractise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserRepository userRepo;


    public List<JournalEntry> getAllJournalEntries(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getJournalEntryById(int journalEntryId){
        return  journalEntryRepository.findById(journalEntryId);
    }

    public void createJournalEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public void updateJournalEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public void deleteJournalEntryById(int journalEntryId){
        journalEntryRepository.deleteById(journalEntryId);
    }

    public JournalEntry createJournalEntryForUser(String username,JournalEntry journalEntry){
        Optional<User> userOpt = userRepo.findByUserName(username);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            user.addJournalEntry(journalEntry);
            userRepo.save(user);
            return journalEntry;
        }
        return null;
    }

    public List<JournalEntry> getAllJournalEntriesForUser(String username){
        Optional<User> userOpt = userRepo.findByUserName(username);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            return user.getJournalEntries();
        }
        return null;
    }
}
