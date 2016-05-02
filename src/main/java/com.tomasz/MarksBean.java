package com.tomasz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.tomasz.beans.MarksController;

/**
 * @author Tomek on 02.05.2016.
 */
@ManagedBean(name = "marksBean")
@ViewScoped
public class MarksBean {

    @Autowired
    MarksController controller;

    public MarksController getController() {
        return controller;
    }

}
