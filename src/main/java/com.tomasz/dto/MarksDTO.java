package com.tomasz.dto;

import java.util.List;

import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.pojo.dao.TUserEngine;

/**
 * @author Tomek on 02.05.2016.
 */
public class MarksDTO {

    private long userId;

    private List<TSubjectEngine>  subjectEngines;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<TSubjectEngine> getSubjectEngines() {
        return subjectEngines;
    }

    public void setSubjectEngines(List<TSubjectEngine> subjectEngines) {
        this.subjectEngines = subjectEngines;
    }
}
