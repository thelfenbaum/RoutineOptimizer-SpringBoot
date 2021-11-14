package api;

import entities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class WeekAndSerializableConverterTest {
    Week week;
    NonFixedTask t1;
    NonFixedTask t2;
    NonFixedTask[] tasks;
    Day day;
    LocalDate startDate;

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
    public void testWeekToWeekSerializable(){
        WeekSerializable expected = new WeekSerializable(startDate, 1l);
        assertSame(expected, WeekAndSerializableConverter.WeekToWeekSerializable(week));
    }

    @Test
    public void testWeekToTaskSerializable(){
        ArrayList<TaskSerializable> expected = new ArrayList<>();
        assertSame(expected, WeekAndSerializableConverter.WeekToTaskSerializable(week));
    }

    @Test
    public void testSerializableToWeek(){
        WeekSerializable weekSers = new WeekSerializable(startDate, 1l);
        ArrayList<TaskSerializable> taskSers = new ArrayList<>();
        assertSame(week, WeekAndSerializableConverter.SerializableToWeek(weekSers, taskSers));
    }
}
