package accessingdatajpa;

import com.csc207.routop.User;

public class UserInteractor {
    private UserRepository userRepo;

    public UserInteractor(UserRepository userRepo){
        this.userRepo = userRepo;
    }


    /**
     * Checks if the username and password match up in the database.
     *
     * @param username: the username input by the user
     * @param password: the password input by the user
     * @return whether they match up
     */
    public static boolean checkSignIn(String username, String password){

    }

    /**
     * Prints the week of a user
     *
     * @param userId: the id of the user
     */
    public static void printWeek(Long userId){

    }


    /**
     * gets the id of a user
     *
     * @param username: the username of the user
     */
    public static long getUserId(String username){

    }

    /**
     * adds the username and password to the database, return their generated userId
     *
     * @param username: the username input by the user
     * @param password: the password input by the user
     */
    public static long addUser(String username, String password){

    }

    public boolean isUsernameInDb(String username) {
        return this.userRepo.existsUserByUsername(username);
    }

    public User getUserFromUsername(String username) {
    }

    public void saveUser(Long userId, String username, String password) {
    }
}
