package com.yourteam.demo.model;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true)
    private String email;

    @Setter
    private String password;

    public User(){}

    public User(String email,String password){
        this.email=email;
        this.password=password;
    }

    public Long getId(){ return id; }
    public String getEmail(){ return email; }
    public String getPassword(){ return password; }

}
