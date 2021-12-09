package com.csc207.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This class is responsible for converting String objects to Date objects.
 */

public class StringToDateTime {

    /**
     * Converts the given string object to a LocalDate object.
     * Precondition: str is correctly formatted as "YYYY-MM-DD".
     * @param str: the string to be converted to a LocalDate.
     *
     * @return the LocalDate represented by this string.
     */
    public static LocalDate stringToLocalDate(String str){
        int startDateYear = Integer.parseInt(str.substring(0, 4));
        int startDateMonth = Integer.parseInt(str.substring(5, 7));
        int startDateDay = Integer.parseInt(str.substring(8, 10));
        return LocalDate.of(startDateYear, startDateMonth, startDateDay);
    }

    /**
     * Convert the given String object to a LocalDateTime object.
     * Precondition: str is correctly formatted as "YYYY-MM-DD$HH:MM", where $ is any character.
     * @param str: the string to be converted to a LocalDateTime.
     *
     * @return the LocalDateTime represented by this string.
     */
    public static LocalDateTime stringToLocalDateTime(String str){
        int dueDateYear = Integer.parseInt(str.substring(0, 4));
        int dueDateMonth = Integer.parseInt(str.substring(5, 7));
        int dueDateDay = Integer.parseInt(str.substring(8, 10));
        int dueTimeHour= Integer.parseInt(str.substring(11, 13));
        int dueTimeMin = Integer.parseInt(str.substring(14, 16));
        return LocalDateTime.of(dueDateYear, dueDateMonth, dueDateDay, dueTimeHour, dueTimeMin);
    }

    /**
     * Converts the String to a LocalTime object.
     * Precondition: str is correctly formatted as "HH:MM".
     * @param str: The time in string format
     * @return The LocalTime object represented by the string.
     */
    public static LocalTime stringToLocalTime(String str){
        int hours = Integer.parseInt(str.substring(0, 2));
        int min = Integer.parseInt(str.substring(3, 5));
        return LocalTime.of(hours, min);
    }
}
