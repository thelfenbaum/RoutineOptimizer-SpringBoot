package com.csc207.cli;

import com.csc207.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SchedulerTest {
    Week week;
    NonFixedTask t1;
    NonFixedTask t2;
    NonFixedTask[] tasks;
    Day day;

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
     * tests the method scheduleTaskInWeek
     */
    @Test
    public void testScheduleTaskInWeek(){
        assertEquals(LocalDateTime.of(2021, 4, 3, 2, 0), Scheduler.ScheduleTaskInWeek(week, t1).getStartDateTime());
    }

    /**
     * tests the method scheduleProject
     */
    @Test
    public void testScheduleProject(){
        assertEquals(LocalDateTime.of(2021, 4, 3, 2, 0), Scheduler.ScheduleProject(week, tasks)[0].getStartDateTime());
    }

    /**
     * tests the method scheduleTaskInDay
     */
    @Test
    public void testScheduleTaskInDay(){
        assertEquals(LocalDateTime.of(2021, 4, 3, 2, 0), Scheduler.ScheduleTaskInDay(day, t2).getStartDateTime());
    }
}
