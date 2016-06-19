package com.tomasz.enums;

/**
 * @author Tomek on 28.05.2016.
 */
public enum EDays {
    MONDAY("Monday", "Poniedziałek"),
    TUESDAY("Tueasday", "Wtorek"),
    WEDNESDAY("Wednesday", "Środa"),
    THURSDAY("Thursday<", "Czwartek"),
    FRIDAY("Friday", "Piątek"),
    SATURDAY("Saturday", "Sobota"),
    SUNDAY("Sunday", "Niedziela");

    private String description;
    private String polishDescription;

    EDays(String description, String polishDescription) {
        this.description = description;
        this.polishDescription = polishDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getPolishDescription() {
        return polishDescription;
    }
}
