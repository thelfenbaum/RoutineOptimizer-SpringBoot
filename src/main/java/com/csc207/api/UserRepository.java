package com.csc207.api;

import com.csc207.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * This class is the user database and is responsible for storing all information about users of the RoutOp application.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Get the user with this username.
     *
     * @param username: the username of the user accessing tasks in the database.
     */
    @Query("Select u from User u where u.username = :username")
    ArrayList<User> getUserByUsername(String username);

    /**
     * Checks if this user is in the database.
     *
     * @param username: the username of the user.
     * @return true if they are in the database, false otherwise.
     */
    boolean existsUserByUsername(String username);
}
