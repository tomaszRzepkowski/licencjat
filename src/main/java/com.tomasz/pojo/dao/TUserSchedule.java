package com.tomasz.pojo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tomek on 26.05.2016.
 */
@Entity
@Table(name = "tbl_user_schedule", schema = "sm", catalog = "")
public class TUserSchedule {
    private long userScheduleId;

    @Id
    @Column(name = "user_schedule_id", nullable = false)
    public long getUserScheduleId() {
        return userScheduleId;
    }

    public void setUserScheduleId(long userScheduleId) {
        this.userScheduleId = userScheduleId;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        TUserSchedule that = (TUserSchedule) o;

        if ( userScheduleId != that.userScheduleId ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) ( userScheduleId ^ ( userScheduleId >>> 32 ) );
    }
}
