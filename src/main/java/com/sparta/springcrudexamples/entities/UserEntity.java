package com.sparta.springcrudexamples.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userRole;
    private Integer userEnabled;

    public UserEntity() {
    }

    public UserEntity(String userName, String userPassword, String userRole, Integer userEnabled) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.userEnabled = userEnabled;
    }

}