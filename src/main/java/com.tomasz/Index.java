package com.tomasz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.io.Serializable;
import java.lang.String;

import com.tomasz.beans.ClassController;
import com.tomasz.beans.UserController;
import com.tomasz.dto.LoginDTO;
import com.tomasz.utils.ApplicationContextProvider;
import com.tomasz.utils.FacesContextProvider;
import com.tomasz.utils.FileUtils;
import com.tomasz.utils.StringUtils;

import static com.tomasz.utils.FacesContextProvider.getApplicationAttributes;
import static com.tomasz.utils.FacesContextProvider.getExternalContext;
import static com.tomasz.utils.FacesContextProvider.getSessionAttributes;

@ManagedBean(name = "applicationBean", eager = true)
@SessionScoped
public class Index implements Serializable{

    ApplicationContext context;

    private String userLogin;
    private String userPassword;
    private String username;
    private UserController controller;
    private ClassController classController;
    private static boolean loginSuccess;
    private boolean loginButtonClicked;
    private LoginDTO loginDTO;
    static Logger logger = Logger.getLogger(Index.class);



    public Index() {
        context = ApplicationContextProvider.getApplicationContext();
        controller = context.getBean(UserController.class);
        classController = context.getBean(ClassController.class);
        logger.info("HelloWorld started!");
    }

    public String handleLogin() {
        if( userLogin != null && !userLogin.equals("") && userPassword != null && !userPassword.equals("")) {
            loginDTO = verifyCredentials(userLogin, userPassword);
            userLogin = null;
            userPassword = null;
            if(loginDTO.isUserFound() && loginDTO.isValidPassword()) {
                loginSuccess = true;
                username = loginDTO.getUsername();
                getSessionAttributes().put("user", loginDTO);
                getClassmatesForUser();
                getStaffClasses();
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
        getExternalContext().invalidateSession();
        getApplicationAttributes().remove("user");
        getSessionAttributes().remove("user");
        return "/views/home.xhtml" + StringUtils.FACES_REDIRECT;
    }

    public boolean isUserStaff() {
        return controller.isUserStaff(loginDTO.getUserId());
    }

//  CLASS BEAN PART
    private void getClassmatesForUser() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        UserController userController = context.getBean(UserController.class);
        if(userController.isUserStaff(userId)) {
            classController.getStudentsForStaff(userId);
        } else {
            classController.getClassmatesForUser(userId);
        }
    }

    private void getStaffClasses() {
        LoginDTO user = (LoginDTO) FacesContextProvider.getSessionAttributes().get("user");
        Long userId = user.getUserId();
        classController.getClasses(userId);
    }

    public ClassController getClassController() {
        return classController;
    }
    //  CLASS BEAN PART

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void downloadTestFile() throws IOException {
        FileUtils.downloadFile();
    }

    public String showUserInfo() {
        return "userInfo.xhtml";
    }

}