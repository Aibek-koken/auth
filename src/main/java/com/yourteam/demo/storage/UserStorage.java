package com.yourteam.demo.storage;

import com.yourteam.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStorage {

    private final Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getEmail(), user);
    }

    public User findByEmail(String email) {
        return users.get(email);
    }
}
