package com.tomasz.pojo.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Tomek on 20.04.2016.
 */
@Entity
@Table(name = "tbl_students", schema = "sm", catalog = "")
public class TStudentEngine {
    private long studentId;
    private String firstName;
    private String lastName;
    private String classIdFk;

    @Id
    @Column(name = "student_id", nullable = false)
    @GeneratedValue
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
    @Column(name = "class_id_fk", nullable = true, length = 45)
    public String getClassIdFk() {
        return classIdFk;
    }

    public void setClassIdFk(String classIdFk) {
        this.classIdFk = classIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TStudentEngine that = (TStudentEngine) o;

        if ( studentId != that.studentId ) return false;
        if ( firstName != null ? !firstName.equals(that.firstName) : that.firstName != null ) return false;
        if ( lastName != null ? !lastName.equals(that.lastName) : that.lastName != null ) return false;
        if ( classIdFk != null ? !classIdFk.equals(that.classIdFk) : that.classIdFk != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( studentId ^ ( studentId >>> 32 ) );
        result = 31 * result + ( firstName != null ? firstName.hashCode() : 0 );
        result = 31 * result + ( lastName != null ? lastName.hashCode() : 0 );
        result = 31 * result + ( classIdFk != null ? classIdFk.hashCode() : 0 );
        return result;
    }
}
