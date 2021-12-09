package com.csc207.cli;

import com.csc207.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertTrue;

/**
 * This class tests the Controller class.
 */

public class ControllerTest {
    Week week;
    FixedTask task1;
    NonFixedTask task2;
    NonFixedTask[] tasks;
    @Before
    public void setUp(){
        LocalDate startDate = LocalDate.of(2021, 4, 3);
        week = new Week(1L, DaysInjector.constructDayList(startDate));
        task1 = new FixedTask("Piano Practice", LocalDateTime.of(2021, 4, 3, 2, 0), LocalTime.of(6, 0), 1L);
        task2 = new NonFixedTask("Skipping", LocalDateTime.of(2021, 4, 3, 2, 0), LocalTime.of(6, 0), 2L);
        tasks = new NonFixedTask[]{task2};
    }

    @After
    public void tearDown(){
    }

    /**
     * Tests activateFixedTaskScheduling method.
     *
     */
    @Test
    public void testActivateFixedTaskScheduling(){
        Controller.activateFixedTaskScheduling(week, task1);
        assertTrue(week.getDays()[0].getTodayTasks().contains(task1));
    }

    /**
     * Tests the activateNonFixedTaskScheduling method.
     */
    @Test
    public void testActivateNonFixedTaskScheduling(){
        Controller.activateNonFixedTaskScheduling(week, task2);
        assertTrue(week.getDays()[0].getTodayTasks().contains(task2));
    }

    /**
     * Tests the activateProjectScheduling method.
     */
    @Test
    public void testActivateProjectScheduling(){
        Controller.activateProjectScheduling(week, tasks);
        assertTrue(week.getDays()[0].getTodayTasks().contains(task2));
    }

    /**
     * Tests the checkProjectScheduling method.
     */
    @Test
    public void testCheckNonFixedTaskScheduling(){
        assertTrue(Controller.checkFixedTaskScheduling(week, task1));
    }

    /**
     * Tests the checkProjectScheduling method.
     */
    @Test
    public void testCheckProjectScheduling(){
        assertTrue(Controller.checkProjectScheduling(week, tasks));
    }

    /**
     * Tests the checkFixedTaskScheduling method.
     */
    @Test
    public void testCheckFixedTaskScheduling(){
        assertTrue(Controller.checkNonFixedTaskScheduling(week, task2));
    }


}
