package com.tomasz.dto;

import java.util.List;

import javax.jms.TopicSubscriber;

import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.pojo.dao.TUserMarksEngine;

/**
 * @author Tomek on 08.05.2016.
 */
public class EditUserDTO {

    private Long classId;
    private Long userId;
    private Long issuedByUserId;
    private String name;
    private String lastName;
    private TUserMarksEngine mark;
    private TSubjectEngine subject;
    private List<TSubjectEngine> avaliableSubjects;

    public EditUserDTO() {
        this.mark = new TUserMarksEngine();
        this.subject = new TSubjectEngine();
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIssuedByUserId() {
        return issuedByUserId;
    }

    public void setIssuedByUserId(Long issuedByUserId) {
        this.issuedByUserId = issuedByUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TUserMarksEngine getMark() {
        return mark;
    }

    public void setMark(TUserMarksEngine mark) {
        this.mark = mark;
    }

    public TSubjectEngine getSubject() {
        return subject;
    }

    public void setSubject(TSubjectEngine subject) {
        this.subject = subject;
    }

    public List<TSubjectEngine> getAvaliableSubjects() {
        return avaliableSubjects;
    }

    public void setAvaliableSubjects(List<TSubjectEngine> avaliableSubjects) {
        this.avaliableSubjects = avaliableSubjects;
    }
}
