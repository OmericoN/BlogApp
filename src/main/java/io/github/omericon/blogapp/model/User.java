package io.github.omericon.blogapp.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private String bio;

    public User(@JsonProperty("username") String username, @JsonProperty("email") String email, @JsonProperty("password") String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    //Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public String getId() {
        return id;
    }
}
