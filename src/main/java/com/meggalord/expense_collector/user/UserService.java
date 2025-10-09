package com.meggalord.expense_collector.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) {
        List<User> result = userRepository.findByUsername(username);
        return result.getFirst();
    }

    public User createUser() {

    }
}
