package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private Integer age;
    private String password;

    public User() {
    }

    public User(String username, String firstname, String lastname, Integer age, String password) {
        super();
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.password = password;
    }
}
