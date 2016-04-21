package com.tomasz.pojo.dao;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tomek on 21.04.2016.
 */
@Entity
@Table(name = "tbl_teachers", schema = "sm", catalog = "")
public class TTeacherEngine {
    private long teacherId;
    private String firstName;
    private String lastName;
    private String degree;
    private Date employmentDate;

    @Id
    @Column(name = "teacher_id", nullable = false)
    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
    @Column(name = "degree", nullable = true, length = 15)
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Basic
    @Column(name = "employment_date", nullable = true)
    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TTeacherEngine that = (TTeacherEngine) o;

        if ( teacherId != that.teacherId ) return false;
        if ( firstName != null ? !firstName.equals(that.firstName) : that.firstName != null ) return false;
        if ( lastName != null ? !lastName.equals(that.lastName) : that.lastName != null ) return false;
        if ( degree != null ? !degree.equals(that.degree) : that.degree != null ) return false;
        if ( employmentDate != null ? !employmentDate.equals(that.employmentDate) : that.employmentDate != null )
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( teacherId ^ ( teacherId >>> 32 ) );
        result = 31 * result + ( firstName != null ? firstName.hashCode() : 0 );
        result = 31 * result + ( lastName != null ? lastName.hashCode() : 0 );
        result = 31 * result + ( degree != null ? degree.hashCode() : 0 );
        result = 31 * result + ( employmentDate != null ? employmentDate.hashCode() : 0 );
        return result;
    }
}
