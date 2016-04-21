package com.tomasz.pojo.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tomek on 21.04.2016.
 */
@Entity
@Table(name = "tbl_subject", schema = "sm", catalog = "")
public class TSubjectEngine {
    private long subjectId;
    private String name;
    private String description;

    @Id
    @Column(name = "subject_id", nullable = false)
    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        TSubjectEngine that = (TSubjectEngine) o;

        if ( subjectId != that.subjectId ) return false;
        if ( name != null ? !name.equals(that.name) : that.name != null ) return false;
        if ( description != null ? !description.equals(that.description) : that.description != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( subjectId ^ ( subjectId >>> 32 ) );
        result = 31 * result + ( name != null ? name.hashCode() : 0 );
        result = 31 * result + ( description != null ? description.hashCode() : 0 );
        return result;
    }
}
