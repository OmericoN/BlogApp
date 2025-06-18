package io.github.omericon.blogapp.service;

import io.github.omericon.blogapp.dao.UserRepository;
import io.github.omericon.blogapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("FakeDao") UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public int addUser(User user){
        return userRepository.insertUser(user);
    }

    public List<User> getAllUsers(){
        return userRepository.selectAllUsers();
    }
}
