package com.csc207.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the WeekToSerializable class.
 */
public class WeekToSerializableAdapterTest {
    Week week;
    LocalDate startDate;
    WeekSerializable weekSer;
    TaskSerializable taskSer;
    ArrayList<TaskSerializable> tasks;
    LocalTime duration;
    LocalDateTime startDateTime;

    /**
     * test setup in common for all the tests below
     */
    @Before
    public void setUp() {
        duration = LocalTime.of(4, 30);
        startDateTime = LocalDateTime.of(2021, 12, 1, 9, 0);
        startDate = LocalDate.of(2021, 11, 20);
        week = new Week(1L, DaysInjector.constructDayList(startDate));
        weekSer = new WeekSerializable(startDate, 1L);
        taskSer = new TaskSerializable("Piano Practice", startDateTime, duration, false, 1L);
        tasks = new ArrayList<>();
        tasks.add(taskSer);

    }

    /**
     * tear down after running each test
     */
    @After
    public void tearDown() {
    }

    /**
     * Tests WeekToWeekSerializable method.
     */
    @Test
    public void testWeekToWeekSerializable(){
        assertEquals(weekSer.getClass(), WeekToSerializableAdapter.WeekToWeekSerializable(week).getClass());
    }

    /**
     * Tests the WeekToTaskSerializable method.
     */
    @Test
    public void testWeekToTaskSerializable(){
        assertEquals(tasks.getClass(), WeekToSerializableAdapter.WeekToTaskSerializable(week).getClass());
    }
}
