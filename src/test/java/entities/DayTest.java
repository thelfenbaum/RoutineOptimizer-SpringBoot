package entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;


public class DayTest {
    LocalDate dayOfMonth;
    Day day;

    @Before
    public void setUp() {
        dayOfMonth = LocalDate.of(2021, 11, 20);
        day = new Day(dayOfMonth);
    }

    @After
    public void tearDown() {
    }

    /**
     * test getDayOfWeek
     */
    @Test
    public void testGetDayOfWeek(){
        DayOfWeek expected;
        expected = dayOfMonth.getDayOfWeek();
        assertEquals(day.getDayOfWeek(), expected);
    }

    /**
     * test getTodaySchedule
     */
    @Test
    public void testGetTodaySchedule(){
        LinkedHashMap<Double, String> expected = new LinkedHashMap<>();
        for(double i = 0.0; i <= 23.5; i = i + 0.5){
            expected.put(i, "");
        }
        assertEquals(expected, day.getTodaySchedule());
    }

    /**
     * test getTodayTasks
     */
    @Test
    public void testGetTodayTasks(){
        ArrayList<Task> todayTasks = new ArrayList<>();
        assertEquals(todayTasks, day.getTodayTasks());
    }

    /**
     * test addTodayTasks
     */
    @Test
    public void testAddTodayTasks(){
        ArrayList<Task> todayTasks = new ArrayList<>();
        Task task;
        task = new Task("Piano", LocalTime.of(9, 30), 1L);
        todayTasks.add(task);
        day.addTodayTasks(task);
        assertEquals(todayTasks, day.getTodayTasks());
    }

    /**
     * test getDayOfMonth
     */
    @Test
    public void testGetDayOfMonth(){
        LocalDate expected = LocalDate.of(2021, 11, 20);
        assertEquals(expected, day.getDayOfMonth());
    }

    /**
     * test putProject
     */
    @Test
    public void testPutProject(){
        LinkedHashMap<Double, String> expected = new LinkedHashMap<>();
        for(double i = 0.0; i <= 23.5; i = i + 0.5){
            expected.put(i, "");
        }
        expected.replace(0.0, "Piano");
        day.putProject(0.0, "Piano");
        assertEquals(expected, day.getTodaySchedule());
    }

    /**
     * test removeTask
     */
    @Test
    public void testRemoveTask(){
        LinkedHashMap<Double, String> expected = new LinkedHashMap<>();
        for(double i = 0.0; i <= 23.5; i = i + 0.5){
            expected.put(i, "");
        }
        Task task;
        task = new Task("Piano", LocalTime.of(9, 30), 2L);
        day.addTodayTasks(task);
        day.removeTask(task);
        assertEquals(expected, day.getTodaySchedule());
    }


}

