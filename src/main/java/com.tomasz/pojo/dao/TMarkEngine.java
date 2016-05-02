package com.tomasz.pojo.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tomek on 02.05.2016.
 */
@Entity
@Table(name = "tbl_mark", schema = "sm", catalog = "")
public class TMarkEngine {
    private long markId;
    private String value;
    private String valueString;
    private String note;

    @Id
    @Column(name = "mark_id", nullable = false)
    public long getMarkId() {
        return markId;
    }

    public void setMarkId(long markId) {
        this.markId = markId;
    }

    @Basic
    @Column(name = "value", nullable = false, length = 5)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "valueString", nullable = false, length = 45)
    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    @Basic
    @Column(name = "note", nullable = true, length = 455)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TMarkEngine that = (TMarkEngine) o;

        if ( markId != that.markId ) return false;
        if ( value != null ? !value.equals(that.value) : that.value != null ) return false;
        if ( valueString != null ? !valueString.equals(that.valueString) : that.valueString != null ) return false;
        if ( note != null ? !note.equals(that.note) : that.note != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( markId ^ ( markId >>> 32 ) );
        result = 31 * result + ( value != null ? value.hashCode() : 0 );
        result = 31 * result + ( valueString != null ? valueString.hashCode() : 0 );
        result = 31 * result + ( note != null ? note.hashCode() : 0 );
        return result;
    }
}
