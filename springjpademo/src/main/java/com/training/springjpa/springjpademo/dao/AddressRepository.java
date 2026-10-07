package com.training.springjpa.springjpademo.dao;

import com.training.springjpa.springjpademo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
