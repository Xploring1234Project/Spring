package com.springpractise.MyPractise.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String userName;
    private String password;

    // One user can have many journal entries
    //mappedBy = "user" ensures the relationship is bidirectional.
    //cascade = CascadeType.ALL means if a user is deleted, their journal entries are also deleted.
    //orphanRemoval = true ensures if a journal entry is removed from the list, it’s deleted from DB.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<JournalEntry> journalEntries = new ArrayList<>();

    // Helper method to add entry
    public void addJournalEntry(JournalEntry entry) {
        journalEntries.add(entry);
        entry.setUser(this);
    }

    // Helper method to remove entry
    /*public void removeJournalEntry(JournalEntry entry) {
        journalEntries.remove(entry);
        entry.setUser(null);
    }*/
}
