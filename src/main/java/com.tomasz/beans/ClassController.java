package com.tomasz.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tomasz.service.UserService;

/**
 * @author Tomek on 02.05.2016.
 */
@Controller
public class ClassController {

    @Autowired
    UserService userService;

    private List<String> classmates;

    public void getClassmatesForUser(Long userId) {
        classmates = userService.getClassmatesForUser(userId);
    }

    public void getClassForStaffId(Long staffId) {
        userService.getClassForStaffId(staffId);
    }

    public List<String> getClassmates() {
        return classmates;
    }

    public void setClassmates(List<String> classmates) {
        this.classmates = classmates;
    }
}
