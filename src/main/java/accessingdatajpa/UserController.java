package accessingdatajpa;

import com.csc207.routop.User;

import java.util.Objects;

public class UserController {
    private final UserInteractor userInt;

    public UserController(UserInteractor userInt){
        this.userInt = userInt;
    }

    public boolean isUsernameAndPasswordInDb(String username, String password){
        if(this.userInt.isUsernameInDb(username)){
            user = this.userInt.getUserFromUsername(username);
            return Objects.equals(user.password, password);
        }
        return false;
    }

    public User getUser(String username){
        return this.userInt.getUserFromUsername(username);
    }


    public void createUsernameAndPasswordInDb(Long userId, String username, String password){
        this.userInt.saveUser(userId, username, password);
    }
}
