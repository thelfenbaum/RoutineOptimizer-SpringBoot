package com.csc207.domain;
import javax.persistence.*;

/**
 * This class represents the user of the routOp application. Each user object contains a username, password, and id.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    /**
     * The constructor for the User class.
     */
    public User(){}

    /**
     * Constructor for the User class that gives the object its username and password.
     * @param username: The username of the user.
     * @param password: The password of the user.
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Get the id.
     * @return The id of the user.
     */
    public Long getId(){
        return this.id;
    }

    /**
     * Get the username.
     * @return the username of the user.
     */
    public String getUsername() {return this.username; }

    /**
     * Get the password.
     * @return The password of the user.
     */
    public String getPassword() {
        return this.password;
    }


}
