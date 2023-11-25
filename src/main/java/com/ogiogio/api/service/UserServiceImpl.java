package com.ogiogio.api.service;

import com.ogiogio.api.contract.UserService;
import com.ogiogio.api.dto.User;
import com.ogiogio.api.exceptions.UserNotFoundException;
import com.ogiogio.api.model.UserEntity;
import com.ogiogio.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User createUser(User user) {
        User existingUser = getUserByEmail(user.getEmail());
        if(!ObjectUtils.isEmpty(existingUser)){
            throw new UserNotFoundException("99", "User already exist with email " +user.getEmail());
        }
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        return modelMapper.map(userRepository.save(userEntity), User.class);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        var response = userRepository.findByEmail(email);
        return response.map(entity -> modelMapper.map(entity, User.class)).orElse(null);
    }
}
