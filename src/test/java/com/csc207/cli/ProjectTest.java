//package com.csc207.cli;
//
//import entities.Day;
//import entities.NonFixedTask;
//import entities.Week;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
//import static org.junit.Assert.assertSame;
//import static org.junit.Assert.assertTrue;
//
//public class ProjectTest {
//    Week week;
//    NonFixedTask t1;
//    NonFixedTask t2;
//    NonFixedTask[] tasks;
//    Day day;
//    LocalDate startDate;
//
//    @Before
//    public void setUp() {
//        startDate = LocalDate.of(2021, 4, 3);
//        week = new Week(startDate, 1L);
//        day = new Day(startDate);
//        t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 4, 12, 0), LocalTime.of(2, 0), 1L);
//        t2 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 6, 12, 0), LocalTime.of(2, 30), 1L);
//        tasks = new NonFixedTask[]{t2};
//    }
//
//    @After
//    public void tearDown(){
//    }
//
//    @Test
//    public void testCalculateMinHours(){
//        assertSame(1.0, Project.calculateMinHours(week, startDate, LocalDateTime.of(2021, 4, 9, 12, 0), 7.0, 7));
//    }
//
//    @Test
//    public void testGetIdealChunk(){
//        assertSame(1.0, Project.getIdealChunk(startDate, LocalDateTime.of(2021, 4, 9, 12, 0), 7.0, 7));
//    }
//
//    @Test
//    public void testFitSchedule(){
//        assertTrue(Project.fitSchedule(week, 1.0));
//    }
//
//    @Test
//    public void testCalculateMaxHoursWeek(){
//        assertSame(24.0, Project.calculateMaxHoursWeek(week));
//    }
//
//    @Test
//    public void testCalculateMaxHoursDay(){
//        assertSame(24, Project.calculateMaxHoursDay(day));
//    }
//}
