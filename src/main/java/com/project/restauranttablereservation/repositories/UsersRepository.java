package com.project.restauranttablereservation.repositories;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.User;

@Transactional
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFirstName(String firstname);
    
    
}
