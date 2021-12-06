package com.csc207.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * This class tests the SerializableToWeekAdapter class.
 */

public class SerializableToWeekAdapterTest {
    WeekSerializable weekSer;
    LocalDate startDate;
    ArrayList<TaskSerializable> taskSers;
    TaskSerializable task1;
    Week week;

    @Before
    public void setup(){
        startDate = LocalDate.of(2021, 4, 12);
        weekSer = new WeekSerializable(startDate, 1L);
        LocalDateTime startDateTime = LocalDateTime.of(2021, 4, 11, 12, 00);
        LocalTime duration = LocalTime.of(1, 0);
        task1 = new TaskSerializable("Piano Practice", startDateTime, duration, false, 2L);
        taskSers = new ArrayList<>();
        taskSers.add(task1);
        Day[] days = {new Day(startDate), new Day(startDate.plusDays(1))};
        week = new Week(3L, days);
    }

    /**
     * This tests the SerializableToWeek method.
     */
    @Test
    public void testSerializableToWeek(){
        assertEquals(week.getClass(), SerializableToWeekAdapter.SerializableToWeek(weekSer, taskSers).getClass());
    }

}
