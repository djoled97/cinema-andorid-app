package com.cinema.demo.repositories;


import com.cinema.demo.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameAndPasswordHash(String username ,String password);
}