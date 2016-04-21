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
@Table(name = "tbl_lessons", schema = "sm", catalog = "")
public class TLessonEngine {
    private long lessonId;
    private String description;

    @Id
    @Column(name = "lesson_id", nullable = false)
    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
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

        TLessonEngine that = (TLessonEngine) o;

        if ( lessonId != that.lessonId ) return false;
        if ( description != null ? !description.equals(that.description) : that.description != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( lessonId ^ ( lessonId >>> 32 ) );
        result = 31 * result + ( description != null ? description.hashCode() : 0 );
        return result;
    }
}
