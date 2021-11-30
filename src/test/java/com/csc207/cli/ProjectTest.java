package com.csc207.cli;

import com.csc207.api.Day;
import com.csc207.api.NonFixedTask;
import com.csc207.api.Week;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectTest {
    Week week;
    NonFixedTask t1;
    NonFixedTask t2;
    NonFixedTask[] tasks;
    Day day;
    LocalDate startDate;

    @Before
    public void setUp() {
        startDate = LocalDate.of(2021, 4, 3);
        week = new Week(startDate, 1L);
        day = new Day(startDate);
        t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 4, 12, 0), LocalTime.of(2, 0), 1L);
        t2 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 6, 12, 0), LocalTime.of(2, 30), 1L);
        tasks = new NonFixedTask[]{t2};
    }

    @After
    public void tearDown(){
    }

    /**
     * tests the method calculateMinHours
     */
    @Test
    public void testCalculateMinHours(){
        assertEquals(1, Project.calculateMinHours(week, startDate, LocalDateTime.of(2021, 4, 10, 12, 0), 7.0, 7), 0.0);
    }

    /**
     * tests the method getIdealChunk
     */
    @Test
    public void testGetIdealChunk(){
        assertEquals(1.0, Project.getIdealChunk(startDate, LocalDateTime.of(2021, 4, 10, 12, 0), 7.0, 7), 0.0);
    }

    /**
     * tests the method fitSchedule
     */
    @Test
    public void testFitSchedule(){
        assertTrue(Project.fitSchedule(week, 1.0));
    }

    /**
     * tests the method calculateMaxHoursWeek
     */
    @Test
    public void testCalculateMaxHoursWeek(){
        assertEquals(24.0, Project.calculateMaxHoursWeek(week), 0);
    }

    /**
     * test the method calculateMaxHoursDay
     */
    @Test
    public void testCalculateMaxHoursDay(){
        assertEquals(24.0, Project.calculateMaxHoursDay(day), 0.0);
    }
}
