package com.tomasz.pojo.dao;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tomek on 02.05.2016.
 */
@Entity
@Table(name = "tbl_user_marks", schema = "sm", catalog = "")
public class TUserMarksEngine {
    private long userMarkId;
    private Date issuedDate;
    private String mark;
    private String markString;
    private String notes;

    @Id
    @Column(name = "user_mark_id", nullable = false)
    public long getUserMarkId() {
        return userMarkId;
    }

    public void setUserMarkId(long userMarkId) {
        this.userMarkId = userMarkId;
    }

    @Basic
    @Column(name = "issued_date", nullable = false)
    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Basic
    @Column(name = "mark", nullable = false, length = 10)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "mark_string", nullable = false, length = 50)
    public String getMarkString() {
        return markString;
    }

    public void setMarkString(String markString) {
        this.markString = markString;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = 600)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TUserMarksEngine that = (TUserMarksEngine) o;

        if ( userMarkId != that.userMarkId ) return false;
        if ( issuedDate != null ? !issuedDate.equals(that.issuedDate) : that.issuedDate != null ) return false;
        if ( mark != null ? !mark.equals(that.mark) : that.mark != null ) return false;
        if ( markString != null ? !markString.equals(that.markString) : that.markString != null ) return false;
        if ( notes != null ? !notes.equals(that.notes) : that.notes != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( userMarkId ^ ( userMarkId >>> 32 ) );
        result = 31 * result + ( issuedDate != null ? issuedDate.hashCode() : 0 );
        result = 31 * result + ( mark != null ? mark.hashCode() : 0 );
        result = 31 * result + ( markString != null ? markString.hashCode() : 0 );
        result = 31 * result + ( notes != null ? notes.hashCode() : 0 );
        return result;
    }
}
