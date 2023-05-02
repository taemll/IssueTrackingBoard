package com.project.IssueTrackingBoard.services;

import com.project.IssueTrackingBoard.controllers.dto.UserDto;
import com.project.IssueTrackingBoard.models.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    User registration(UserDto dto);
    Optional<User> findByUsername(String username);
    ResponseEntity<?> login(UserDto dto);
}