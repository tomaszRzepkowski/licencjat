package com.tomasz.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.service.MarkService;
import com.tomasz.service.UserService;

/**
 * @author Tomek on 02.05.2016.
 */
@Controller
public class MarksController {

    @Autowired
    MarkService markService;

    public List<TSubjectEngine> getSubjectsForUser(String username) {
        return markService.getSubjectsForUser(username);
    }
}
