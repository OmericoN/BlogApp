package io.github.omericon.blogapp.api;

import io.github.omericon.blogapp.service.UserService;
import io.github.omericon.blogapp.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
