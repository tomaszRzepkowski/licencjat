package com.tomasz.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tomasz.dto.LoginDTO;
import com.tomasz.pojo.dao.TUserEngine;
import com.tomasz.service.UserService;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 13.04.2016.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    private String name;

    public void siemanko() {
        String name = userService.getUserByID(1).getName();
        this.setName(name);
    }

    public String handleLogin() {
        //TODO wrzucic robienie query
        return "";
    }

    public String test() {
        return userService.getTest();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoginDTO verifyCredentials(String login, String password) {
        TUserEngine user = userService.getUserByLogin(login);
        LoginDTO loginDTO = new LoginDTO();
        if(user != null) {
            loginDTO.setUserFound(true);
            loginDTO.setValidPassword(user.getPassword().equals(password));
            loginDTO.setUsername(login);
            loginDTO.setUserId(user.getUserId());
            userService.updateUserLoginDate(user.getUserId());
        }

        return loginDTO;
    }

    public TUserEngine getUserByLogin(String login) {
        return userService.getUserByLogin(login);
    }

    public List<TUserEngine> getCurrentUser() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionParameter("user");
        List<TUserEngine> users = new ArrayList<TUserEngine>();
        TUserEngine userByLogin = userService.getUserByLogin(user.getUsername());
        users.add(userByLogin);
        return users;
    }
}
