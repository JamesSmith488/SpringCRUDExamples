package com.sparta.springcrudexamples.repositories;

import com.sparta.springcrudexamples.entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity, String> {
}
