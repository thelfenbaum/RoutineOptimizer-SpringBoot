package com.csc207.cli;

import com.csc207.domain.NonFixedTask;
import com.csc207.domain.Putter;
import com.csc207.domain.Week;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PutterTest {
    Week week;
    NonFixedTask t1;
    NonFixedTask t2;
    NonFixedTask[] tasks;
    @Before
    public void setUp(){
        LocalDate startDate = LocalDate.of(2021, 4, 3);
        week = new Week(startDate, 1L);
        t1 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 5, 12, 0), LocalTime.of(2, 30), 1L);
        t2 = new NonFixedTask("Piano Practice", LocalDateTime.of(2021, 4, 6, 12, 0), LocalTime.of(2, 30), 1L);
        tasks = new NonFixedTask[]{t1, t2};
    }

    @After
    public void tearDown(){
    }

    /**
     * tests the method putTask
     */
    @Test
    public void testPutTask(){
        Putter.putTask(week, t1);
        assertSame("", week.getDays()[2].getTodaySchedule().get(12.0));
    }

    /**
     * tests the method putProject
     */
    @Test
    public void testPutProject(){
        Putter.putProject("Practice Piano", week, tasks);
        assertSame("", week.getDays()[2].getTodaySchedule().get(12.0));
        assertSame("", week.getDays()[3].getTodaySchedule().get(12.0));
    }
}
