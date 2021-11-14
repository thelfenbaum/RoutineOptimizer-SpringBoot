package api;

import entities.User;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class UserController {
    private final UserInteractor userInt;

    public UserController(UserInteractor userInt){
        this.userInt = userInt;
    }

    /**
     * Check if both the username and password of this user are in the database.
     *
     * @param username: the username.
     * @param password: the password.
     * @return whether this username-password pair is in the database.
     */
    @SuppressWarnings("unused")
    public boolean isUsernameAndPasswordInDb(String username, String password){
        if(this.userInt.isUsernameInDb(username)){
            User user = this.userInt.getUserFromUsername(username);
            return Objects.equals(user.getPassword(), password);
        }
        return false;
    }


    /**
     * Returns a user object from the database based on the user's username.
     *
     * @param username: the username.
     * @return the user associated with this username.
     */
    @SuppressWarnings("unused")
    public User getUser(String username){
        return this.userInt.getUserFromUsername(username);
    }

    /**
     * Save this User entity to the database.
     *
     * @param user: the User.
     */
    public void saveUser(User user){
        this.userInt.saveUser(user);
    }
}
