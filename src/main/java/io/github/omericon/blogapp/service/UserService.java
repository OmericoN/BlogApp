package io.github.omericon.blogapp.service;

import io.github.omericon.blogapp.dao.UserRepository;
import io.github.omericon.blogapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired  // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(User user) {
        // Add any validation or preprocessing here if needed
        return userRepository.saveUser(user);
    }

    public Optional<User> getUserById(String id) throws Exception {
        return userRepository.getUserById(id);
    }

    public List<User> getAllUsers() throws Exception {
        return userRepository.getAllUsers();
    }

    public boolean deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

    // Add more business logic methods here as needed
}
