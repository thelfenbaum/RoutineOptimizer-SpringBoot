package com.csc207.domain;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name= "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


    public Long getId(){
        return this.id;
    }


    public String getPassword() {
        return this.password;
    }
}
