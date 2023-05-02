package com.project.IssueTrackingBoard.services.impl;

import com.project.IssueTrackingBoard.configuration.JwtUtils;
import com.project.IssueTrackingBoard.controllers.dto.UserDto;
import com.project.IssueTrackingBoard.models.User;
import com.project.IssueTrackingBoard.repositories.RoleRepository;
import com.project.IssueTrackingBoard.repositories.UserRepository;
import com.project.IssueTrackingBoard.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    @Override
    public User registration(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> login(UserDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());

        if(userDetails != null) {
            String token = jwtUtils.generateToken(userDetails);
            return ResponseEntity.ok("token created: " + token);
        }

        return ResponseEntity.badRequest().body("Something wrong with authentication");
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }
}