package com.yourteam.demo.service;

import com.yourteam.demo.model.User;
import com.yourteam.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String register(String email, String password){
        if(userRepository.findByEmail(email)!=null){
            return "User already exists";
        }
        User user = new User(email,password);
        userRepository.save(user);
        return "User has been registered";
    }

    public String login(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user==null){
            return "Please register";
        }
        if(!user.getPassword().equals(password)){
            return "Wrong password";
        }
        return "You logged in succesfully";
    }
}
