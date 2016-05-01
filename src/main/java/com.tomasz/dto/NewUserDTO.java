package com.tomasz.dto;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;

import com.tomasz.pojo.dao.TUserEngine;

/**
 * @author Tomek on 23.04.2016.
 */
public class NewUserDTO {

//    private HtmlInputText name;
//    private HtmlInputText lastName;
//    private HtmlInputText address1;
//    private HtmlInputText address2;
//    private HtmlInputText city;
//    private HtmlInputText username;
//    private HtmlInputText email;
//    private HtmlInputText password;
//    private HtmlInputText phone;
//    private UIInput date;
//    private String dateString;

    private String name;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String date;
    private String dateString;

    private boolean nameValid;
    private boolean lastNameValid;
    private boolean address1Valid;
    private boolean address2Valid;
    private boolean cityValid;
    private boolean usernameValid;
    private boolean emailValid;
    private boolean passwordValid;
    private boolean phoneValid;
    private boolean dateValid;

    private TUserEngine user;

    public TUserEngine getUser() {
        if(user == null) {
            user = new TUserEngine();
        }
        return user;
    }

//    public HtmlInputText getName() {
//        return name;
//    }
//
//    public void setName(HtmlInputText name) {
//        this.name = name;
//    }
//
//    public HtmlInputText getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(HtmlInputText lastName) {
//        this.lastName = lastName;
//    }
//
//    public HtmlInputText getAddress1() {
//        return address1;
//    }
//
//    public void setAddress1(HtmlInputText address1) {
//        this.address1 = address1;
//    }
//
//    public HtmlInputText getAddress2() {
//        return address2;
//    }
//
//    public void setAddress2(HtmlInputText address2) {
//        this.address2 = address2;
//    }
//
//    public HtmlInputText getCity() {
//        return city;
//    }
//
//    public void setCity(HtmlInputText city) {
//        this.city = city;
//    }
//
//    public HtmlInputText getUsername() {
//        return username;
//    }
//
//    public void setUsername(HtmlInputText username) {
//        this.username = username;
//    }
//
//    public HtmlInputText getEmail() {
//        return email;
//    }
//
//    public void setEmail(HtmlInputText email) {
//        this.email = email;
//    }
//
//    public HtmlInputText getPassword() {
//        return password;
//    }
//
//    public void setPassword(HtmlInputText password) {
//        this.password = password;
//    }
//
//    public HtmlInputText getPhone() {
//        return phone;
//    }
//
//    public void setPhone(HtmlInputText phone) {
//        this.phone = phone;
//    }
//
//    public UIInput getDate() {
//        return date;
//    }
//
//    public void setDate(UIInput date) {
//        this.date = date;
//    }
//
//    public String getDateString() {
//        return dateString;
//    }
//
//    public void setDateString(String dateString) {
//        this.dateString = dateString;
//    }
//
//    public void setUser(TUserEngine user) {
//        this.user = user;
//    }
//
    public boolean isNameValid() {
        return nameValid;
    }

    public void setNameValid(boolean nameValid) {
        this.nameValid = nameValid;
    }

    public boolean isLastNameValid() {
        return lastNameValid;
    }

    public void setLastNameValid(boolean lastNameValid) {
        this.lastNameValid = lastNameValid;
    }

    public boolean isAddress1Valid() {
        return address1Valid;
    }

    public void setAddress1Valid(boolean address1Valid) {
        this.address1Valid = address1Valid;
    }

    public boolean isAddress2Valid() {
        return address2Valid;
    }

    public void setAddress2Valid(boolean address2Valid) {
        this.address2Valid = address2Valid;
    }

    public boolean isCityValid() {
        return cityValid;
    }

    public void setCityValid(boolean cityValid) {
        this.cityValid = cityValid;
    }

    public boolean isUsernameValid() {
        return usernameValid;
    }

    public void setUsernameValid(boolean usernameValid) {
        this.usernameValid = usernameValid;
    }

    public boolean isEmailValid() {
        return emailValid;
    }

    public void setEmailValid(boolean emailValid) {
        this.emailValid = emailValid;
    }

    public boolean isPasswordValid() {
        return passwordValid;
    }

    public void setPasswordValid(boolean passwordValid) {
        this.passwordValid = passwordValid;
    }

    public boolean isPhoneValid() {
        return phoneValid;
    }

    public void setPhoneValid(boolean phoneValid) {
        this.phoneValid = phoneValid;
    }

    public boolean isDateValid() {
        return dateValid;
    }

    public void setDateValid(boolean dateValid) {
        this.dateValid = dateValid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
