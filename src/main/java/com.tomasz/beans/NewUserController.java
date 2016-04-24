package com.tomasz.beans;

import javax.faces.application.FacesMessage;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tomasz.dto.NewUserDTO;
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
        newUserDTO.setEmailValid(EmailValidator.getInstance().isValid(String.valueOf(newUserDTO.getEmail().getValue())));
        return false;
    }

    private void addValidationMessages() {
        if(newUserDTO.isEmailValid()) {
            FacesContextProvider.getFacesContext().addMessage("Please provide valid e-mail ex. name@domain.com", new FacesMessage("siema"));
        }
    }
}
