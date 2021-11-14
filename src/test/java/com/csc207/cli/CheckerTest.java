package com.csc207.cli;

import entities.FixedTask;
import entities.NonFixedTask;

import entities.Week;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CheckerTest {
    Week week;
    @Before
    public void setUp(){
        LocalDate startDate = LocalDate.of(2021, 4, 3);
        week = new Week(startDate, 1L);
    }

    @After
    public void tearDown(){
    }

    @Test
    public void testCheckScheduleProject(){
        NonFixedTask t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        NonFixedTask[] projectTask = {t1};
        assertSame(false, Checker.CheckScheduleProject(week, projectTask));
    }

    @Test
    public void testCheckScheduleNonFixedTask(){
        NonFixedTask t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        assertSame(false, Checker.CheckScheduleNonFixedTask(week, t1));
    }

    @Test
    public void testCheckScheduleFixedTask(){
        FixedTask t2 = new FixedTask("Jogging", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        assertSame(false, Checker.CheckScheduleFixedTask(week, t2));
    }
}
