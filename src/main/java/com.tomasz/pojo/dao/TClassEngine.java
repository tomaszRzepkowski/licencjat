package com.tomasz.pojo.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Tomek on 21.04.2016.
 */
@Entity
@Table(name = "tbl_class", schema = "sm", catalog = "")
public class TClassEngine {
    private long classId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "classEngine")
    private List<TUserClassEngine> userClass;

    @Id
    @Column(name = "class_id", nullable = false)
    @GeneratedValue
    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 15)
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

    @Transient
    public List<TUserClassEngine> getUserClass() {
        return userClass;
    }

    @Transient
    public void setUserClass(List<TUserClassEngine> userClass) {
        this.userClass = userClass;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TClassEngine that = (TClassEngine) o;

        if ( classId != that.classId ) return false;
        if ( name != null ? !name.equals(that.name) : that.name != null ) return false;
        if ( description != null ? !description.equals(that.description) : that.description != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( classId ^ ( classId >>> 32 ) );
        result = 31 * result + ( name != null ? name.hashCode() : 0 );
        result = 31 * result + ( description != null ? description.hashCode() : 0 );
        return result;
    }
}
