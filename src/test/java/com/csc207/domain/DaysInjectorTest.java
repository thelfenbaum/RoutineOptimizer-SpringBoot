package com.csc207.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the DayInjector class.
 */

public class DaysInjectorTest {
    LocalDate startDate;

    @Before
    public void setUp() {
        startDate = LocalDate.of(2021, 11, 20);
    }

    /**
     * Tests constructDayList method.
     */
    @Test
    public void testConstructDayList(){
        LocalDate date2 = LocalDate.of(2021, 11, 21);
        LocalDate date3 = LocalDate.of(2021, 11, 22);
        LocalDate date4 = LocalDate.of(2021, 11, 23);
        LocalDate date5 = LocalDate.of(2021, 11, 24);
        LocalDate date6 = LocalDate.of(2021, 11, 25);
        LocalDate date7 = LocalDate.of(2021, 11, 26);

        Day day1 = new Day(startDate);
        Day day2 = new Day(date2);
        Day day3 = new Day(date3);
        Day day4 = new Day(date4);
        Day day5 = new Day(date5);
        Day day6 = new Day(date6);
        Day day7 = new Day(date7);


        Day[] expected = {day1, day2, day3, day4, day5, day6, day7};
        Day[] actual = DaysInjector.constructDayList(startDate);

        for(int day = 0; day < 7; day++){
            assertEquals(expected[day].getDayOfMonth(), actual[day].getDayOfMonth());
        }
    }
}
