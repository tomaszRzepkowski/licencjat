package com.tomasz;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;

import com.tomasz.beans.NewUserController;
import com.tomasz.dto.NewUserDTO;
import com.tomasz.utils.ApplicationContextProvider;

/**
 * @author Tomek on 23.04.2016.
 */
@ManagedBean(name = "newUserBean", eager = true)
@ViewScoped
public class NewUserBean {

    ApplicationContext context;
    NewUserController controller;
    private boolean validationErrors;


    public NewUserBean() {
        context = ApplicationContextProvider.getApplicationContext();
        controller = context.getBean(NewUserController.class);
    }

    public void validate(){
        controller.validateNewUserForm();
    }

    public Date getDate() {
        Date date = new Date();
        return date;
    }

    public String getDateString() {
        Date date = new Date();
        return date.toString();
    }

    public NewUserDTO getNewUserDTO() {
        return controller.getNewUserDTO();
    }

    public boolean isValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(boolean validationErrors) {
        this.validationErrors = validationErrors;
    }
}
