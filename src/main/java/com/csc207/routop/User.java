package com.csc207.routop;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", columnDefinition = "text[]")
    public String username;
    @Column(name = "password", columnDefinition = "text[]")
    public String password;

    protected User() {}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
