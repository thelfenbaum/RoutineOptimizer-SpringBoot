package com.csc207.api;

import com.csc207.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private final UserInteractorDataOut userInteractorDataOut;
    @Autowired
    private final UserInteractorDataIn userInteractorDataIn;

    public UserController(UserInteractorDataOut userInteractorDataOut, UserInteractorDataIn userInteractorDataIn){
        this.userInteractorDataOut = userInteractorDataOut;
        this.userInteractorDataIn = userInteractorDataIn;
    }

    /**
     * Check if both the username and password of this uwser are in the database.
     *
     * @param username: the username.
     * @param password: the password.
     * @return whether this username-password pair is in the database.
     */
    public boolean isUsernameAndPasswordInDb(String username, String password){
        if(this.userInteractorDataOut.isUsernameInDb(username)){
            User user = this.userInteractorDataOut.getUserFromUsername(username);
            return Objects.equals(user.getPassword(), password);
        }
        return false;
    }


    /**
     * Returns a user object from the database based on the user's username.
     * @param username: the username.
     * @return the user associated with this username.
     */
    public User getUser(String username){
        return this.userInteractorDataOut.getUserFromUsername(username);
    }

    /**
     * Save this User entity to the database.
     *
     * @param user: the User.
     */
    @Transactional
    public void saveUser(User user){
        this.userInteractorDataIn.saveUser(user);
    }
}