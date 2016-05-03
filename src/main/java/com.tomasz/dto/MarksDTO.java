package com.tomasz.dto;

import java.util.Date;
import java.util.List;

import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.pojo.dao.TUserEngine;

/**
 * @author Tomek on 02.05.2016.
 */
public class MarksDTO {

    private Long studentId;
    private Long issuedById;
    private String mark;
    private String markString;
    private String markType;
    private String notes;
    private Date issuedDate;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getIssuedById() {
        return issuedById;
    }

    public void setIssuedById(Long issuedById) {
        this.issuedById = issuedById;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMarkString() {
        return markString;
    }

    public void setMarkString(String markString) {
        this.markString = markString;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMarkType() {
        return markType;
    }

    public void setMarkType(String markType) {
        this.markType = markType;
    }
}
