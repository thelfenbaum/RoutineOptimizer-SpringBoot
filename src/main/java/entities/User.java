package entities;

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

    @Deprecated(since = "we will not be manually setting an ID, as Spring Boot will manage " +
            "these IDs to ensure they match the database")
    private void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
