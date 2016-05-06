package com.tomasz;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.context.ApplicationContext;

import com.tomasz.beans.ClassController;
import com.tomasz.beans.MarksController;
import com.tomasz.dto.LoginDTO;
import com.tomasz.dto.MarksDTO;
import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.utils.ApplicationContextProvider;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 05.05.2016.
 */
@ManagedBean(name = "classBean")
@ViewScoped
public class ClassBean {

    ApplicationContext context;

    private ClassController classController;

    public ClassBean() {
        context = ApplicationContextProvider.getApplicationContext();
        classController = context.getBean(ClassController.class);
        getClassmatesForUser();
    }

    public void getClassmatesForUser() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        classController.getClassmatesForUser(userId);
    }

    public ClassController getClassController() {
        return classController;
    }
}
