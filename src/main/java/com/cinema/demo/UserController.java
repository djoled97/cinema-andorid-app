package com.cinema.demo;

import com.cinema.demo.enteties.Role;
import com.cinema.demo.enteties.User;
import com.cinema.demo.repositories.RoleRepository;
import com.cinema.demo.repositories.UserRepository;

import com.cinema.demo.security.MyUserDetailsService;
import com.fasterxml.jackson.core.JsonpCharacterEscapes;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController

public class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/api/users")
    public @ResponseBody
    List
    getAllUsers() {
        return userRepo.findAll();

    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "welcome",produces = "application/json")
    public @ResponseBody Optional<User> welcome(){
        User user=myUserDetailsService.getUserFromSession();
        int  id=user.getId();
        return userRepo.findById(id);
//        return new ResponseEntity("user authentiacted",HttpStatus.OK);


    }

    @GetMapping("/api/loggedUser" )
       public @ResponseBody
    Optional<User> getLoggedUser(){
        User user=myUserDetailsService.getUserFromSession();
      int  id=user.getId();
        return userRepo.findById(id);
    }

//    @GetMapping("/login")
//    public void login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//
//    }



    @PostMapping("/api/users")
    public ResponseEntity newUser(@RequestBody User newUser) {
//       String pass=newUser.getPasswordHash();
//        SecureRandom random = new SecureRandom();
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
//
//        try {
//            MessageDigest md = null;
//            md = MessageDigest.getInstance("SHA-512");
//            md.update(salt);
//            byte[] bytes = md.digest(pass.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i< bytes.length ;i++)
//            {
//
//                sb.append(Integer.toString(bytes[i] , 16).substring(1).toUpperCase());
//            }
//
//            pass = sb.toString();
//            newUser.setPasswordHash(pass);
//        } catch (Exception e) {
//            e.getMessage();
//        }


            if(userRepo.findByUsername(newUser.getUsername())!=null){
                return new ResponseEntity("Username taken",HttpStatus.NOT_ACCEPTABLE);
        }
            else  if(userRepo.findByEmail(newUser.getEmail())!=null){
                return new ResponseEntity( "Email taken"  ,HttpStatus.NOT_EXTENDED);
            }
       newUser.setPasswordHash(bCryptPasswordEncoder.encode(newUser.getPasswordHash()));

      Role role= roleRepo.findById(2).get();
        newUser.setRole(role);




        return new ResponseEntity(userRepo.save(newUser), HttpStatus.CREATED);
    }
    @PostMapping("/api/admin")
    public ResponseEntity newAdmin(@RequestBody User newAdmin) {
//       String pass=newUser.getPasswordHash();
//        SecureRandom random = new SecureRandom();
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
//
//        try {
//            MessageDigest md = null;
//            md = MessageDigest.getInstance("SHA-512");
//            md.update(salt);
//            byte[] bytes = md.digest(pass.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i< bytes.length ;i++)
//            {
//
//                sb.append(Integer.toString(bytes[i] , 16).substring(1).toUpperCase());
//            }
//
//            pass = sb.toString();
//            newUser.setPasswordHash(pass);
//        } catch (Exception e) {
//            e.getMessage();
//        }
        newAdmin.setPasswordHash(bCryptPasswordEncoder.encode(newAdmin.getPasswordHash()));
        Role role= roleRepo.findById(1).get();
        newAdmin.setRole(role);




        return new ResponseEntity(userRepo.save(newAdmin), HttpStatus.CREATED);
    }

    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$\n";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}
