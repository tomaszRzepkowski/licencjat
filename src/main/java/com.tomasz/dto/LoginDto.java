package com.tomasz.dto;

/**
 * @author Tomek on 15.04.2016.
 */
public class LoginDTO {

    boolean validPassword;
    boolean userFound;

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
