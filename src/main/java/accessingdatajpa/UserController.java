package accessingdatajpa;

import com.csc207.routop.User;

import java.util.Objects;

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
    public boolean isUsernameAndPasswordInDb(String username, String password){
        if(this.userInt.isUsernameInDb(username)){
            User user = this.userInt.getUserFromUsername(username);
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
        return this.userInt.getUserFromUsername(username);
    }

    /**
     * Add this username-password pair (along with the user id) to the database.
     * @param username: the username.
     * @param password: the password.
     */
    public void createUsernameAndPasswordInDb(String username, String password){
        this.userInt.saveUser(username, password);
    }
}
