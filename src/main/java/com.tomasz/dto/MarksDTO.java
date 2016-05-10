package com.tomasz.dto;

import java.util.Date;

/**
 * @author Tomek on 02.05.2016.
 */
public class MarksDTO {

    private Long studentId;
    private Long issuedById;
    private String subjectName;
    private String issuedByName;
    private String issuedByLastName;
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

    public String getIssuedByName() {
        return issuedByName;
    }

    public void setIssuedByName(String issuedByName) {
        this.issuedByName = issuedByName;
    }

    public String getIssuedByLastName() {
        return issuedByLastName;
    }

    public void setIssuedByLastName(String issuedByLastName) {
        this.issuedByLastName = issuedByLastName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public boolean getMarkBoolValue() {
        Integer valueOfMark = Integer.parseInt(String.valueOf(this.mark.charAt(0)));
        return valueOfMark > 2;
    }
}
