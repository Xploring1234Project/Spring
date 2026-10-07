package com.training.springjpa.springjpademo.dao;

import com.training.springjpa.springjpademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
