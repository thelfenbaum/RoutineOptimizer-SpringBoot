package com.csc207.cli;

import com.csc207.domain.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CheckerTest {
    Week week;
    @Before
    public void setUp(){
        LocalDate startDate = LocalDate.of(2021, 4, 3);
        week = new Week(1L, DaysInjector.constructDayList(startDate));
    }

    @After
    public void tearDown(){
    }

    /**
     * Tests CheckScheduleProject method with an array of 1 non-fixed task and checks that the project is not
     * scheduled in
     *
     */
    @Test
    public void testCheckScheduleProject(){
        NonFixedTask t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        NonFixedTask[] projectTask = {t1};
        assertTrue(Checker.CheckScheduleProject(week, projectTask));
    }

    /**
     * Tests CheckScheduleNonFixedTask method with a week and a non-fixed task, when there is no task scheduled in week.
     */
    @Test
    public void testCheckScheduleNonFixedTask(){
        NonFixedTask t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        assertTrue(Checker.CheckScheduleNonFixedTask(week, t1));
    }

    /**
     * Tests CheckScheduleFixedTask method with a week and a fixed task, when there is no tasks scheduled in the week.
     */
    @Test
    public void testCheckScheduleFixedTask(){
        FixedTask t2 = new FixedTask("Jogging", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        assertTrue(Checker.CheckScheduleFixedTask(week, t2));
    }
}
