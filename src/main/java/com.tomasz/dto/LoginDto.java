package com.tomasz.dto;

import java.io.Serializable;

/**
 * @author Tomek on 15.04.2016.
 */
public class LoginDTO implements Serializable{

    long userId;

    boolean validPassword;
    boolean userFound;

    private String username;
    private String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidPassword() {
        return validPassword;
    }

    public void setValidPassword(boolean validPassword) {
        this.validPassword = validPassword;
    }

    public boolean isUserFound() {
        return userFound;
    }

    public void setUserFound(boolean userFound) {
        this.userFound = userFound;
    }
}
