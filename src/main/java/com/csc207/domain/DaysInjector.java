package com.csc207.domain;

import java.time.LocalDate;

/**
 * A class which constructs a list of seven consecutive Day objects to be
 * injected into the Week constructor.
 */
public class DaysInjector {
    /**
     * Returns a list of seven consecutive Day objects.
     *
     * @param startDate: the LocalDate of the first Day object.
     * @return a list of seven consecutive Day objects.
     */
    public static Day[] constructDayList(LocalDate startDate){
        Day[] days = new Day[7];
        for(int day = 0; day <= 6; day++){
          days[day] = new Day(startDate.plusDays(day));
        }
        return days;
    }
}
