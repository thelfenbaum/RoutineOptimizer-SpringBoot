package com.csc207.api;

import com.csc207.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.List;

@Configuration
public class UserInteractorDataOut {
    @Autowired
    private final UserRepository userRepo;

    public UserInteractorDataOut(UserRepository userRepo){
        this.userRepo = userRepo;
    }


    /**
     * Check if the username and password match up in the database.
     *
     * @param username: the username input by the user
     * @param password: the password input by the user
     * @return whether they match up
     */
    public boolean checkSignIn(String username, String password){
        boolean existsUser = this.userRepo.existsUserByUsername(username);
        if (existsUser) {
            String expectedPassword = this.userRepo.getUserByUsername(username).get(0).getPassword();
            return password.equals(expectedPassword);
        }
        return false;
    }

    /**
     * Get the id of a user.
     *
     * @param username: the Username of the user.
     */
    public long getUserIdByUsername(String username){
        return this.userRepo.getUserByUsername(username).get(0).getId();
    }

    public boolean isUsernameInDb(String username) {
        return this.userRepo.existsUserByUsername(username);
    }

    public User getUserFromUsername(String username) {
        return this.userRepo.getUserByUsername(username).get(0);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
