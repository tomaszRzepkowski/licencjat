package com.tomasz;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.context.ApplicationContext;

import com.tomasz.beans.ScheduleController;
import com.tomasz.dto.LoginDTO;
import com.tomasz.utils.ApplicationContextProvider;
import com.tomasz.utils.FacesContextProvider;

/**
 * @author Tomek on 28.05.2016.
 */
@ManagedBean(name = "scheduleBean", eager = true)
@ViewScoped
public class ScheduleBean implements Serializable {

    ApplicationContext context;
    ScheduleController controller;

    public ScheduleBean() {
        context = ApplicationContextProvider.getApplicationContext();
        controller = context.getBean(ScheduleController.class);
        showScheduleForCurrentUser();
    }

    public void showScheduleForCurrentUser() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        long userId = user.getUserId();
        controller.prepareScheduleForUserId(userId);
    }

    public ScheduleController getController() {
        return controller;
    }
}
