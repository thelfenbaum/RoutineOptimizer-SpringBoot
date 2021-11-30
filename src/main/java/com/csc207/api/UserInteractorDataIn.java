package com.csc207.api;

import com.csc207.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

@Configuration
public class UserInteractorDataIn {
    @Autowired
    private final UserRepository userRepo;

    public UserInteractorDataIn(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    /**
     * Save this user to the database.
     *
     * @param user: the User.
     */
    @Transactional
    public void saveUser(User user) {
        this.userRepo.save(user);
    }
}
