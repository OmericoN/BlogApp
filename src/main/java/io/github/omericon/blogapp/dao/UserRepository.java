package io.github.omericon.blogapp.dao;

import io.github.omericon.blogapp.model.User;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository {
    public String saveUser(User user);
    public Optional<User> getUser(String id);
    public List<User> getAllUsers() throws Exception;

}
