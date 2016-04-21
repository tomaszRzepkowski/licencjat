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
@Table(name = "tbl_marks", schema = "sm", catalog = "")
public class TMarkEngine {
    private long markId;
    private Date issueDate;
    private String description;

    @Id
    @Column(name = "mark_id", nullable = false)
    public long getMarkId() {
        return markId;
    }

    public void setMarkId(long markId) {
        this.markId = markId;
    }

    @Basic
    @Column(name = "issue_date", nullable = false)
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TMarkEngine that = (TMarkEngine) o;

        if ( markId != that.markId ) return false;
        if ( issueDate != null ? !issueDate.equals(that.issueDate) : that.issueDate != null ) return false;
        if ( description != null ? !description.equals(that.description) : that.description != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( markId ^ ( markId >>> 32 ) );
        result = 31 * result + ( issueDate != null ? issueDate.hashCode() : 0 );
        result = 31 * result + ( description != null ? description.hashCode() : 0 );
        return result;
    }
}
