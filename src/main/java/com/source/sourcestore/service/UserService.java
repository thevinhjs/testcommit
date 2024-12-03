package com.source.sourcestore.service;

import com.source.sourcestore.dto.request.UserCreationRequest;
import com.source.sourcestore.dto.request.UserUpdateRequest;
import com.source.sourcestore.entity.User;
import com.source.sourcestore.exception.AppException;
import com.source.sourcestore.exception.ErrorCode;
import com.source.sourcestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername())) {
            throw  new AppException(ErrorCode.USER_EXCEPTED);
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setBirthday(request.getBirthday());
        return userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUser(String id) {
        return userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);


        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setBirthday(request.getBirthday());
        return userRepository.save(user);

    }
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
