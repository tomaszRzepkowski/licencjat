package com.tomasz.beans;

import java.sql.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tomasz.dto.NewUserDTO;
import com.tomasz.pojo.dao.TUserEngine;
import com.tomasz.service.UserService;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 23.04.2016.
 */
@Controller
public class NewUserController {

    @Autowired
    UserService userService;

    private NewUserDTO newUserDTO;
    private boolean userExists = false;

    public NewUserDTO getNewUserDTO() {
        if(newUserDTO == null) {
            newUserDTO = new NewUserDTO();
        }
        return newUserDTO;
    }

    public void setNewUserDTO(NewUserDTO newUserDTO) {
        this.newUserDTO = newUserDTO;
    }

    public boolean validateNewUserForm() {
        newUserDTO.setEmailValid(EmailValidator.getInstance().isValid(String.valueOf(newUserDTO.getEmail())));
        addValidationMessages();
        return false;
    }

    private void addValidationMessages() {
//,
    }

    public String saveNewUser() {
        TUserEngine userEngine;
        userEngine = createUserFromDTO(newUserDTO);
        userEngine.setUserType("STUDENT");
        String result = userService.createUser(userEngine);
        if(result.equals("SUCCESS")) {
            return "home.xhtml?faces-redirect=true";
        } else {
            userExists = true;
            return "USER_EXISTS";
        }
    }

    private TUserEngine createUserFromDTO(NewUserDTO newUserDTO) {
        TUserEngine user = new TUserEngine();
        user.setName(newUserDTO.getName());
        user.setLastName(newUserDTO.getLastName());
        user.setAddress1(newUserDTO.getAddress1());
        user.setAddress2(newUserDTO.getAddress2());
        user.setCity(newUserDTO.getCity());
        user.setEmail(newUserDTO.getEmail());
        user.setPassword(newUserDTO.getPassword());
        user.setUsername(newUserDTO.getUsername());
        user.setBirthDate((Date) Date.valueOf(newUserDTO.getDateString()));
        return user;
    }

    public boolean isUserExists() {
        return userExists;
    }

    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }
}
