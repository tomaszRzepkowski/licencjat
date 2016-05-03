package com.tomasz;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.context.ApplicationContext;

import com.tomasz.beans.MarksController;
import com.tomasz.dto.LoginDTO;
import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.utils.ApplicationContextProvider;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 02.05.2016.
 */
@ManagedBean(name = "marksBean")
@ViewScoped
public class MarksBean {

    ApplicationContext context;
    MarksController controller;
    private List<TSubjectEngine> userSubjects;
    private String siema = "Siema";

    public MarksController getController() {
        return controller;
    }

    public MarksBean() {
        context = ApplicationContextProvider.getApplicationContext();
        controller = context.getBean(MarksController.class);
        userSubjects = getSubjectsForCurrentUser();
    }

    private List<TSubjectEngine> getSubjectsForCurrentUser() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        String username = user.getUsername();
        return controller.getSubjectsForUser(username);
    }

    public List<TSubjectEngine> getUserSubjects() {
        return userSubjects;
    }

    public void setUserSubjects(List<TSubjectEngine> userSubjects) {
        this.userSubjects = userSubjects;
    }

    public String getSiema() {
        return siema;
    }

    public void setSiema(String siema) {
        this.siema = siema;
    }
}
