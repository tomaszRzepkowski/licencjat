package com.tomasz.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tomasz.dto.LoginDTO;
import com.tomasz.pojo.dao.TClassEngine;
import com.tomasz.pojo.dao.TUserEngine;
import com.tomasz.service.UserService;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 02.05.2016.
 */
@Controller
public class ClassController {

    @Autowired
    UserService userService;

    private List<TUserEngine> classmates;
    private List<TClassEngine> classes;

    public void getClassmatesForUser(Long userId) {
        classmates = userService.getClassmatesForUser(userId);
    }

    public void getStudentsForStaff(Long userId) {
        classmates = userService.getStudentsForStaff(userId);
    }

    public void getClassmatesForCurrentUser() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        classmates = userService.getClassmatesForUser(userId);
    }

    public void getClassForStaffId(Long staffId) {
        userService.getClassForStaffId(staffId);
    }

    public List<TUserEngine> getClassmates() {
        return classmates;
    }

    public void setClassmates(List<TUserEngine> classmates) {
        this.classmates = classmates;
    }

    public void getClasses(Long userId) {
        classes = userService.getClasses(userId);
    }

    public List<TClassEngine> getClasses() {
        return classes;
    }

    public void setClasses(List<TClassEngine> classes) {
        this.classes = classes;
    }
}
