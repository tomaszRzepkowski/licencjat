package com.tomasz;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.mail.Email;
import org.springframework.context.ApplicationContext;

import com.tomasz.beans.MarksController;
import com.tomasz.dto.EditUserDTO;
import com.tomasz.dto.LoginDTO;
import com.tomasz.dto.MarksDTO;
import com.tomasz.enums.EMarks;
import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.utils.ApplicationContextProvider;
import com.tomasz.utils.DateUtils;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 02.05.2016.
 */
@ManagedBean(name = "marksBean")
@ViewScoped
public class MarksBean implements Serializable{

    ApplicationContext context;
    MarksController controller;

    private static final String EDIT_PARAMETER_NAME = "markEditUserId";
    private static final String USER_ID_PARAMETER_NAME = "selectedUserId";
    private List<TSubjectEngine> userSubjects;
    private List<MarksDTO> marksForSubject;
    private EditUserDTO editUserDTO;
    private Long selectedSubject;
    private Long selectedUserId;

    public MarksController getController() {
        return controller;
    }

    public MarksBean() {
        context = ApplicationContextProvider.getApplicationContext();
        controller = context.getBean(MarksController.class);
        userSubjects = getSubjectsForCurrentUser();
        if(FacesContextProvider.isSessionContainsKey(EDIT_PARAMETER_NAME)) {
            selectedUserId = (Long) FacesContextProvider.getSessionParameter(EDIT_PARAMETER_NAME);
            FacesContextProvider.removeSessionParameter(EDIT_PARAMETER_NAME);
            LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
            Long userId = user.getUserId();
            editUserDTO = controller.getUserDataForEdit(userId, selectedUserId);
        }
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

    public void setSelectedSubject(Long selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public Long getSelectedSubject() {
        return selectedSubject;
    }

    public EditUserDTO getEditUserDTO() {
        return editUserDTO;
    }

    public void setEditUserDTO(EditUserDTO editUserDTO) {
        this.editUserDTO = editUserDTO;
    }

    public String getSelectedSubjectForView(){
        for(TSubjectEngine engine : userSubjects) {
            if(engine.getSubjectId().equals(selectedSubject)) {
                return engine.getName();
            }
        }
        return "Subject not found";
    }

    public List<EMarks> getAvaliableMarks() {
        List<EMarks> markses = new ArrayList<EMarks>();
        for(EMarks mark : EMarks.values()) {
            markses.add(mark);
        }
        return markses;
    }

    public void prepareEditData(ActionEvent event) {
        Long selectedUserId = (Long) event.getComponent().getAttributes().get(USER_ID_PARAMETER_NAME);
        this.selectedUserId = selectedUserId;
        FacesContextProvider.putSessionParameter(EDIT_PARAMETER_NAME, selectedUserId);
    }

    public String editPageRedirect() {
        return "editMarks.xhtml?faces-redirect=true&userId=" + selectedUserId.toString();
    }

    public String manageUserPageRedirect() {
        return "manageUser.xhtml?faces-redirect=true&userId=" + selectedUserId.toString();
    }

    public Long getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(Long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    public String addMarkForUser() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        String markId = editUserDTO.getMark().getMark();
        EMarks markById = EMarks.getMarkById(Integer.parseInt(markId));
        editUserDTO.setIssuedByUserId(userId);
        editUserDTO.getMark().setIssuedDate(Date.valueOf(DateUtils.getCurrentDate()));
        editUserDTO.getMark().setMark(markById.getStringValue());
        editUserDTO.getMark().setMarkString(markById.getDescription());
        controller.addMarkForUser(editUserDTO);
        return "class.xhtml";
    }
}
