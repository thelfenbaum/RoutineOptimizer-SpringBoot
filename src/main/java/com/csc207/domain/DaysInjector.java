package com.csc207.domain;

import java.time.LocalDate;

public class DaysInjector {
    public static Day[] constructDayList(LocalDate startDate){
        Day[] days = new Day[7];
        for(int i = 0; i <= 6; i++){
          days[i] = new Day(startDate.plusDays(i));
        }
        return days;
    }
}
