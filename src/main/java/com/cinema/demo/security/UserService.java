//package com.cinema.demo.security;
//
//import com.cinema.demo.enteties.Role;
//import com.cinema.demo.enteties.User;
//import com.cinema.demo.repositories.RoleRepository;
//import com.cinema.demo.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//@Service
//public class UserService {
//
//private UserRepository userRepository;
//private RoleRepository roleRepository;
//private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository,
//                       RoleRepository roleRepository,
//                       BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//    public User findUserByEmail(String email){
//        return  userRepository.findByEmail(email);
//    }
//    public User findUserByUsername(String username){
//        return  userRepository.findByUserName(username);
//    }
//    public User saveUser(User user){
//        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPasswordHash()));
//        Role userRole=roleRepository.findByRole("admin");
//
//        return  userRepository.save(user);
//    }
//
//
//}
