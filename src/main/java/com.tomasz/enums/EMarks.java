package com.tomasz.enums;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author Tomek on 08.05.2016.
 */
public enum EMarks {
    ONE(1, "One"),
    ONE_PLUS(2, "One and a half"),
    TWO(3, "Two"),
    TWO_PLUS(4, "Two and a half"),
    THREE(5, "Three"),
    THREE_PLUS(6, "Three and a half"),
    FOUR(7, "Four"),
    FOUR_PLUS(8, "Four and a half"),
    FIVE(9, "Five"),
    FIVE_PLUS(10, "Five and a half"),
    SIX_PLUS(11, "Six");

    private int id;
    private String description;

    EMarks(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static EMarks getMarkById(int id) {
        for(EMarks value : EMarks.values()) {
            if(value.getId() == id) {
                return value;
            }
        }
        return null;
    }

    public EMarks getMarkByDescription(String description) {
        for(EMarks value : EMarks.values()) {
            if(value.getDescription().equals(description)) {
                return value;
            }
        }
        return null;
    }

    public List<EMarks> getList() {
        List<EMarks> markses = new ArrayList<EMarks>();
        for(EMarks mark : EMarks.values()) {
            markses.add(mark);
        }
        return markses;
    }
}
