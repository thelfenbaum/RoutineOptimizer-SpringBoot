package com.csc207.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the CreateProject class.
 */

public class CreateProjectTest {
    Week week;
    NonFixedTask t1;
    NonFixedTask t2;
    NonFixedTask[] tasks;
    Day day;
    LocalDate startDate;

    @Before
    public void setUp() {
        startDate = LocalDate.of(2021, 4, 3);
        week = new Week(1L, DaysInjector.constructDayList(startDate));
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
        assertEquals(1, CreateProject.calculateMinHours(week, startDate, LocalDateTime.of(2021, 4, 10, 12, 0), 7.0, 7), 0.0);
    }

    /**
     * tests the method getIdealChunk
     */
    @Test
    public void testGetIdealChunk(){
        assertEquals(1.0, CreateProject.getIdealChunk(startDate, LocalDateTime.of(2021, 4, 10, 12, 0), 7.0, 7), 0.0);
    }

    /**
     * tests the method fitSchedule
     */
    @Test
    public void testFitSchedule(){
        assertTrue(CreateProject.fitSchedule(week, 1.0));
    }

    /**
     * tests the method calculateMaxHoursWeek
     */
    @Test
    public void testCalculateMaxHoursWeek(){
        assertEquals(24.0, CreateProject.calculateMaxHoursWeek(week), 0);
    }

    /**
     * test the method calculateMaxHoursDay
     */
    @Test
    public void testCalculateMaxHoursDay(){
        assertEquals(24.0, CreateProject.calculateMaxHoursDay(day), 0.0);
    }
}
