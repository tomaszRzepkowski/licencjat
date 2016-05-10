package com.tomasz.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomek on 08.05.2016.
 */
public enum EMarks {
    ONE(1, "1", "One"),
    ONE_PLUS(2, "1+", "One and a half"),
    TWO(3, "2", "Two"),
    TWO_PLUS(4, "2+", "Two and a half"),
    THREE(5, "3", "Three"),
    THREE_PLUS(6, "3+", "Three and a half"),
    FOUR(7, "4", "Four"),
    FOUR_PLUS(8, "4+", "Four and a half"),
    FIVE(9, "5", "Five"),
    FIVE_PLUS(10, "5+", "Five and a half"),
    SIX_PLUS(11, "6", "Six");

    private int id;
    private String stringValue;
    private String description;

    EMarks(int id, String description) {
        this.id = id;
        this.description = description;
    }


    EMarks(int i, String s, String one) {
        this.id = i;
        this.stringValue = s;
        this.description = one;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static EMarks getMarkById(int id) {
        for(EMarks value : EMarks.values()) {
            if(value.getId() == id) {
                return value;
            }
        }
        return EMarks.ONE;
    }

    public static String getMarkStringValueById(int id ) {
        for(EMarks value : EMarks.values()) {
            if(value.getId() == id) {
                return value.getStringValue();
            }
        }
        return "";
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
