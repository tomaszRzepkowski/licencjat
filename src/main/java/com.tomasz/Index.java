package com.tomasz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.lang.String;
import java.util.Enumeration;

import com.tomasz.beans.UserController;
import com.tomasz.dto.LoginDTO;
import com.tomasz.utils.ApplicationContextProvider;
import com.tomasz.utils.StringUtils;

import static com.tomasz.utils.FacesContextProvider.getExternalContext;
import static com.tomasz.utils.FacesContextProvider.getSessionAttributes;

@ManagedBean(name = "helloWorld", eager = true)
@SessionScoped
public class Index {

    ApplicationContext context;

    private String userLogin;
    private String userPassword;
    private UserController controller;
    private static boolean loginSuccess;
    private boolean loginButtonClicked;
    private LoginDTO loginDTO;
    static Logger logger = Logger.getLogger(Index.class);



    public Index() {
        context = ApplicationContextProvider.getApplicationContext();
        controller = (UserController) context.getBean(UserController.class);
        logger.info("HelloWorld started!");
    }
    public String getMessage() {

        controller.siemanko();
        String test = controller.getName();
        return "Hello World!" + test;
    }

    public String handleLogin() {
        if( userLogin != null && !userLogin.equals("") && userPassword != null && !userPassword.equals("")) {
            loginDTO = verifyCredentials(userLogin, userPassword);
            userLogin = null;
            userPassword = null;
            if(loginDTO.isUserFound() && loginDTO.isValidPassword()) {
                loginSuccess = true;
                getSessionAttributes().put("user", loginDTO);
                return "logged/loggedHome.xhtml";
            }
            loginSuccess = false;
            return "home.xhtml";
        } else {
            getSessionAttributes().remove("user");
            loginSuccess = false;
            return StringUtils.ERROR;
        }
    }

    private LoginDTO verifyCredentials(String login, String password) {
        return controller.verifyCredentials(login, password);
    }


    private void resetParameters() {
        loginSuccess = false;
        loginButtonClicked = false;
    }

    public String handleLogout() {
        resetParameters();
        return "/views/home.xhtml" + StringUtils.FACES_REDIRECT;
    }

    public UserController getController() {
        return controller;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public boolean isLoginButtonClicked() {
        return loginButtonClicked;
    }

    public void setLoginButtonClicked(boolean loginButtonClicked) {
        this.loginButtonClicked = loginButtonClicked;
    }

}