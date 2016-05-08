package com.tomasz.pojo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Tomek on 06.05.2016.
 */
@Entity
@Table(name = "tbl_user_class", schema = "sm", catalog = "")
public class TUserClassEngine {
    private long userClassId;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private TUserEngine user;

    @ManyToOne
    @JoinColumn(name = "class_id_fk")
    private TClassEngine classEngine;


    @Id
    @Column(name = "user_class_id", nullable = false)
    public long getUserClassId() {
        return userClassId;
    }

    public void setUserClassId(long userClassId) {
        this.userClassId = userClassId;
    }

    @Transient
    public TUserEngine getUser() {
        return user;
    }

    @Transient
    public void setUser(TUserEngine user) {
        this.user = user;
    }

    @Transient
    public TClassEngine getClassEngine() {
        return classEngine;
    }

    @Transient
    public void setClassEngine(TClassEngine classEngine) {
        this.classEngine = classEngine;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TUserClassEngine that = (TUserClassEngine) o;

        if ( userClassId != that.userClassId ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) ( userClassId ^ ( userClassId >>> 32 ) );
    }
}
