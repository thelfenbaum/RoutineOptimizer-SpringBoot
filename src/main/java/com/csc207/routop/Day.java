package com.csc207.routop;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Each day should comprise its date, day, and a map with half-hour intervals as keys and task names as values.
 * The empty string as a value represents no task being scheduled, i.e. free time.
 */

public class Day {
    public LocalDate dayOfMonth;
    public DayOfWeek dayOfWeek;
    public Map<Double, String> todaySchedule;

    /**
     *
     * Construct a Day, giving the day its day of month, day of week and the schedule of the day
     * @param dayOfMonth the day of month
     */

    public Day(LocalDate dayOfMonth){
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfMonth.getDayOfWeek();
        this.todaySchedule = new HashMap<>();
        // Set all initial half-hour blocks to the empty string, which represents
        // no task scheduled (free time)/
        for(double i = 0.0; i <= 23.5; i = i + 0.5){
            this.todaySchedule.put(i, "");
        }
    }

    /**
     * Return the string representation of a day that lists its day of week and schedule.
     */

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("------ ").append(this.dayOfWeek).append(" ------\n");
        for(Double time: this.todaySchedule.keySet()){
            s.append(time).append(": ").append(this.todaySchedule.get(time)).append("\n");
        }
        return(s.toString());
    }


}
