package com.csc207.routop;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name= "bigint", nullable = false)
    private double id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    private String password;

    protected User(){}

    public double getId(){
        return this.id;
    }

    @Deprecated(since = "we will not be manually setting an ID, as Spring Boot will manage " +
            "these IDs to ensure they match the database")
    private void setId(Long id) {
        this.id = id;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
