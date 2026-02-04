package com.yourteam.demo.service;

import com.yourteam.demo.model.User;
import com.yourteam.demo.storage.UserStorage;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserStorage userStorage;

    public AuthService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public String register(String email, String password) {
        if (userStorage.findByEmail(email) != null) {
            return "User already exists";
        }

        User user = new User(email, password);
        userStorage.save(user);
        return "User registered";
    }

    public String login(String email, String password) {
        User user = userStorage.findByEmail(email);

        if (user == null) {
            return "User not found";
        }

        if (!user.getPassword().equals(password)) {
            return "Wrong password";
        }

        return "Login success";
    }
}
