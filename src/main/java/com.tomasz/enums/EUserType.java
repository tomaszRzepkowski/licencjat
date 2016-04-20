package com.tomasz.enums;

/**
 * Created by Tomek on 20.04.2016.
 */
public enum EUserType {
    STUDENT("Student"),
    TEACHER("Teacher"),
    STAFF("Staff");

    private String descritpion;

    EUserType(String descritpion) {
        this.descritpion = descritpion;
    }
    
    private String getDescription(EUserType type){
        return type.descritpion;
    }

    private EUserType getTypeByDescritption(String descritpion) {
        if(descritpion.equals("Student")) {
            return STUDENT;
        }
        if(descritpion.equals("Teacher")) {
            return TEACHER;
        }
        if(descritpion.equals("Staff")) {
            return STAFF;
        }
        return null;
    }
}
