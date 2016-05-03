package com.tomasz.pojo.dao;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Tomek on 02.05.2016.
 */
@Entity
@Table(name = "tbl_subject", schema = "sm", catalog = "")
public class TSubjectEngine {
    private Long subjectId;
    private String name;

    @OneToMany(mappedBy = "subject")
    private List<TUserSubjectEngine> userSubject;

    @Id
    @Column(name = "subject_id", nullable = false)
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 70)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TSubjectEngine that = (TSubjectEngine) o;

        if ( subjectId != that.subjectId ) return false;
        if ( name != null ? !name.equals(that.name) : that.name != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( subjectId ^ ( subjectId >>> 32 ) );
        result = 31 * result + ( name != null ? name.hashCode() : 0 );
        return result;
    }
}
