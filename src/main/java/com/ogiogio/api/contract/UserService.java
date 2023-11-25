package com.ogiogio.api.contract;

import com.ogiogio.api.dto.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserByEmail(String email);
}
