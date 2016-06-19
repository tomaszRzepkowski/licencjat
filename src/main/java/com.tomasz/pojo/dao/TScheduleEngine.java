package com.tomasz.pojo.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tomek on 26.05.2016.
 */
@Entity
@Table(name = "tbl_schedule", schema = "sm", catalog = "")
public class TScheduleEngine {
    private long scheduleId;
    private String time;
    private String day;
    private String place;
    private String notes;

    @Id
    @Column(name = "schedule_id", nullable = false)
    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Basic
    @Column(name = "time", nullable = false, length = 10)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "day", nullable = false, length = 20)
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Basic
    @Column(name = "place", nullable = true, length = 125)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = 455)
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

        TScheduleEngine that = (TScheduleEngine) o;

        if ( scheduleId != that.scheduleId ) return false;
        if ( time != null ? !time.equals(that.time) : that.time != null ) return false;
        if ( day != null ? !day.equals(that.day) : that.day != null ) return false;
        if ( place != null ? !place.equals(that.place) : that.place != null ) return false;
        if ( notes != null ? !notes.equals(that.notes) : that.notes != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( scheduleId ^ ( scheduleId >>> 32 ) );
        result = 31 * result + ( time != null ? time.hashCode() : 0 );
        result = 31 * result + ( day != null ? day.hashCode() : 0 );
        result = 31 * result + ( place != null ? place.hashCode() : 0 );
        result = 31 * result + ( notes != null ? notes.hashCode() : 0 );
        return result;
    }
}
