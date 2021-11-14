package com.csc207.cli;

import entities.Day;
import entities.NonFixedTask;
import entities.Week;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertSame;

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
        week = new Week(startDate, 1L);
        day = new Day(startDate);
        t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        t2 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 6, 12, 0), LocalTime.of(2, 30), 1L);
        tasks = new NonFixedTask[]{t2};
    }

    @After
    public void tearDown(){
    }

    @Test
    public void testScheduleTaskInWeek(){
        assertSame(LocalDateTime.of(2021, 4, 3, 0, 0), Scheduler.ScheduleTaskInWeek(week, t1).getStartDateTime());
    }

    @Test
    public void testScheduleProject(){
        assertSame(LocalDateTime.of(2021, 4, 3, 0, 0), Scheduler.ScheduleProject(week, tasks)[0].getStartDateTime());
    }

    @Test
    public void testScheduleTaskInDay(){
        assertSame(LocalDateTime.of(2021, 4, 3, 0, 0), Scheduler.ScheduleTaskInDay(day, t2).getStartDateTime());
    }
}
