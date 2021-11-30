package com.csc207.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class ConvertBetweenTimeAndDouble {

    /** Takes a LocalDateTime object and outputs a double object that represents the time in the LocalDateTime object.
     *
     *
     * @param localTime: The LocalDateTime object that is being converted to type double
     * @return localTime converted to a Double, where the digits before the decimal point represent the hours and the
     * digits after the decimal point represent the minutes (e.g. 2.5 is two hours and a half)
     */
    public static double ConvertDateTimeDouble (LocalDateTime localTime){
        double hour = localTime.getHour();
        int minute = localTime.getMinute();
        double minuteDouble = ((double)minute/60);
        return hour + minuteDouble;
    }

    /** Takes a LocalTime object and outputs a double object that represents the time in the LocalTime object.
     * The digits before the decimal point represent the hours and the digits after the decimal point represent the
     * minutes in the double representation
     *
     * @param localTime: The LocalTime object that is being converted to type double
     * @return localTime converted to a Double, where the digits before the decimal point represent the hours and the
     * digits after the decimal point represent the minutes (e.g. 2.5 is two hours and a half)
     */
    public static double ConvertLocalTimeDouble (LocalTime localTime){
        double hour = localTime.getHour();
        int minute = localTime.getMinute();
        double minuteDouble = ((double)minute/60);
        return hour + minuteDouble;
    }

    /** Takes a double object and converts it into a LocalTIme object, where the digits before the decimal point represent the hours and the
     * digits after the decimal point represent the minutes
     *
     * @param time: The time that is being converted from double to LocalTime
     * @return time as a LocalTime object.
     */
    public static LocalTime ConvertDoubleToLocalTime (Double time){
        int hour = (int)Math.floor(time);
        int minute = (int)((time - hour)*60);
        return LocalTime.of(hour, minute);
    }


}
