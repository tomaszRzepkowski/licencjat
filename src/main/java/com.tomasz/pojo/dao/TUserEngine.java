package com.tomasz.pojo.dao;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tomasz.enums.EUserType;

/**
 * Created by Tomek on 20.04.2016.
 */
@Entity
@Table(name = "tbl_user", schema = "sm")
public class TUserEngine {

    private long userId;
    private String name;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private Date birthDate;
    private String loginDate;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String userType;

    @ManyToOne
    @JoinColumn(name = "class_id_fk")
    private TClassEngine clazz;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "address1", nullable = true, length = 45)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "address2", nullable = true, length = 45)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "birth_date", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "user_type", nullable = false, length = 15)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "login_date", nullable = true)
    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }


    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TUserEngine that = (TUserEngine) o;

        if ( userId != that.userId ) return false;
        if ( name != null ? !name.equals(that.name) : that.name != null ) return false;
        if ( lastName != null ? !lastName.equals(that.lastName) : that.lastName != null ) return false;
        if ( address1 != null ? !address1.equals(that.address1) : that.address1 != null ) return false;
        if ( address2 != null ? !address2.equals(that.address2) : that.address2 != null ) return false;
        if ( city != null ? !city.equals(that.city) : that.city != null ) return false;
        if ( birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null ) return false;
        if ( username != null ? !username.equals(that.username) : that.username != null ) return false;
        if ( password != null ? !password.equals(that.password) : that.password != null ) return false;
        if ( email != null ? !email.equals(that.email) : that.email != null ) return false;
        if ( phone != null ? !phone.equals(that.phone) : that.phone != null ) return false;
        if ( userType != null ? !userType.equals(that.userType) : that.userType != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( userId ^ ( userId >>> 32 ) );
        result = 31 * result + ( name != null ? name.hashCode() : 0 );
        result = 31 * result + ( lastName != null ? lastName.hashCode() : 0 );
        result = 31 * result + ( address1 != null ? address1.hashCode() : 0 );
        result = 31 * result + ( address2 != null ? address2.hashCode() : 0 );
        result = 31 * result + ( city != null ? city.hashCode() : 0 );
        result = 31 * result + ( birthDate != null ? birthDate.hashCode() : 0 );
        result = 31 * result + ( username != null ? username.hashCode() : 0 );
        result = 31 * result + ( password != null ? password.hashCode() : 0 );
        result = 31 * result + ( email != null ? email.hashCode() : 0 );
        result = 31 * result + ( phone != null ? phone.hashCode() : 0 );
        result = 31 * result + ( userType != null ? userType.hashCode() : 0 );
        return result;
    }
}
