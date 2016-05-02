package com.tomasz.pojo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tomek on 02.05.2016.
 */
@Entity
@Table(name = "tbl_user_subject", schema = "sm", catalog = "")
public class TUserSubjectEngine {
    private long userSubjectId;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private TUserEngine user;

    @ManyToOne
    @JoinColumn(name = "subject_id_fk")
    private TSubjectEngine subject;


    @Id
    @Column(name = "user_subject_id", nullable = false)
    public long getUserSubjectId() {
        return userSubjectId;
    }

    public void setUserSubjectId(long userSubjectId) {
        this.userSubjectId = userSubjectId;
    }


    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TUserSubjectEngine that = (TUserSubjectEngine) o;

        if ( userSubjectId != that.userSubjectId ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) ( userSubjectId ^ ( userSubjectId >>> 32 ) );
    }
}
