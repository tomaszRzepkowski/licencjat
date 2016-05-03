package com.tomasz;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.context.ApplicationContext;

import com.tomasz.beans.MarksController;
import com.tomasz.dto.LoginDTO;
import com.tomasz.dto.MarksDTO;
import com.tomasz.dto.NewUserDTO;
import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.utils.ApplicationContextProvider;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 02.05.2016.
 */
@ManagedBean(name = "marksBean")
@ViewScoped
public class MarksBean implements Serializable{

    ApplicationContext context;
    MarksController controller;
    private List<TSubjectEngine> userSubjects;
    private List<MarksDTO> marksForSubject;
    private String siema = "Siema";
    private Long selectedSubject;

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

    public void getMarksForSelectedSubject() {
        Long subjectId = selectedSubject;
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        marksForSubject = controller.getMarksForSubject(userId, subjectId);
    }

    public void getMarksForAllSubjects() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        marksForSubject = controller.getMarksForAllSubjects(userId);
    }

    public List<MarksDTO> getMarksForSubject() {
        return marksForSubject;
    }

    public void setMarksForSubject(List<MarksDTO> marksForSubject) {
        this.marksForSubject = marksForSubject;
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

    public void setSelectedSubject(Long selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public Long getSelectedSubject() {
        return selectedSubject;
    }

    public String getSelectedSubjectForView(){
        for(TSubjectEngine engine : userSubjects) {
            if(engine.getSubjectId().equals(selectedSubject)) {
                return engine.getName();
            }
        }
        return "Subject not found";
    }
}
