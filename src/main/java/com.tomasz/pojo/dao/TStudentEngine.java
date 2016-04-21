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
@Table(name = "tbl_students", schema = "sm", catalog = "")
public class TStudentEngine {
    private long studentId;
    private String firstName;
    private String lastName;
    private Date dateStarted;

    @Id
    @Column(name = "student_id", nullable = false)
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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
    @Column(name = "date_started", nullable = true)
    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TStudentEngine that = (TStudentEngine) o;

        if ( studentId != that.studentId ) return false;
        if ( firstName != null ? !firstName.equals(that.firstName) : that.firstName != null ) return false;
        if ( lastName != null ? !lastName.equals(that.lastName) : that.lastName != null ) return false;
        if ( dateStarted != null ? !dateStarted.equals(that.dateStarted) : that.dateStarted != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( studentId ^ ( studentId >>> 32 ) );
        result = 31 * result + ( firstName != null ? firstName.hashCode() : 0 );
        result = 31 * result + ( lastName != null ? lastName.hashCode() : 0 );
        result = 31 * result + ( dateStarted != null ? dateStarted.hashCode() : 0 );
        return result;
    }
}
