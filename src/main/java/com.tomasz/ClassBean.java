package com.tomasz;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.context.ApplicationContext;

import com.tomasz.beans.ClassController;
import com.tomasz.beans.MarksController;
import com.tomasz.beans.UserController;
import com.tomasz.dto.LoginDTO;
import com.tomasz.dto.MarksDTO;
import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.utils.ApplicationContextProvider;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 05.05.2016.
 */
@ManagedBean(name = "classBean")
@SessionScoped
public class ClassBean {

    ApplicationContext context;

    private ClassController classController;

    public ClassBean() {
        context = ApplicationContextProvider.getApplicationContext();
        classController = context.getBean(ClassController.class);
        getClassmatesForUser();
        getStaffClasses();
    }

    public void getClassmatesForUser() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        UserController userController = context.getBean(UserController.class);
        if(userController.isUserStaff(userId)) {
            classController.getStudentsForStaff(userId);
        } else {
            classController.getClassmatesForUser(userId);
        }
    }

    public void getStaffClasses() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        UserController userController = context.getBean(UserController.class);
        if(userController.isUserStaff(userId)) {
            classController.getClasses(userId);
        }
    }

    public ClassController getClassController() {
        return classController;
    }
}
