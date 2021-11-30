package com.csc207.api;


import com.csc207.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WeekAndSerializableConverterTest {
    Week week;
    NonFixedTask t1;
    NonFixedTask t2;
    NonFixedTask[] tasks;
    Day day;
    LocalDate startDate;

    @Before
    public void setUp(){
        LocalDate startDate = LocalDate.of(2021, 4, 3);
        week = new Week(1L, DaysInjector.constructDayList(startDate));
        day = new Day(startDate);
        t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        t2 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 6, 12, 0), LocalTime.of(2, 30), 1L);
        tasks = new NonFixedTask[]{t2};
    }

    @After
    public void tearDown(){
    }

    /**
     * test weekToWeekSerializable
     */
    @Test
    public void testWeekToWeekSerializable(){
        WeekSerializable expected = new WeekSerializable(startDate, 1L);
        assertEquals(expected, WeekToSerializableAdapter.WeekToWeekSerializable(week));
    }

    /**
     * test WeekToTaskSerializable
     */
    @Test
    public void testWeekToTaskSerializable(){
        ArrayList<TaskSerializable> expected = new ArrayList<>();
        assertEquals(expected, WeekToSerializableAdapter.WeekToTaskSerializable(week));
    }

    /**
     * test SerializableToWeek
     */
    @Test
    public void testSerializableToWeek(){
        WeekSerializable weekSers = new WeekSerializable(startDate, 1L);
        ArrayList<TaskSerializable> taskSers = new ArrayList<>();
        assertEquals(week, SerializableToWeekAdapter.SerializableToWeek(weekSers, taskSers));
    }
}
