package com.springpractise.MyPractise.repository;

import com.springpractise.MyPractise.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry,Integer> {
}
