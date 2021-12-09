package com.csc207.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * This class tests the Task class.
 */

public class TaskTest {
    LocalTime duration;
    Task task;
    @Before
    public void setUp() {
        duration = LocalTime.of(4, 30);
        task = new Task("Piano Practice", duration, 1L);
        }

    @After
    public void tearDown() {
    }

    /**
     * test complete
     */
    @Test
    public void testComplete() {
        task.complete();
        assertTrue(task.isCompleted());
    }
    /**
     * test getName
     */
    @Test
    public void testGetName(){
        assertSame("Piano Practice", task.getName());
    }

    /**
     * test getUserId
     */
    @Test
    public void testGetUserId(){
        assertSame(1L, task.getUserId());
    }

    /**
     * test changeName
     */
    @Test
    public void testChangeName(){
        task.changeName("Workout");
        assertSame("Workout", task.getName());
    }

    /**
     * test getStartDateTime
     */
    @Test
    public void testGetStartDateTime(){
        LocalDateTime expected;
        expected = LocalDateTime.of(0, 1, 1, 0, 0);
        assertTrue(task.getStartDateTime().isEqual(expected));
    }

    /**
     * test getDuration
     */
    @Test
    public void testGetDuration(){
        assertSame(duration, task.getDuration());
    }

    /**
     * test isCompleted
     */
    @Test
    public void testIsCompleted(){
        assertSame(false, task.isCompleted());
    }

    /**
     * test changeStartDateTime
     */
    @Test
    public void testChangeStartDateTime(){
        LocalDateTime time;
        time = LocalDateTime.of(2021, 11, 22, 9, 30);
        task.changeStartDateTime(time);
        assertTrue(task.getStartDateTime().isEqual(time));
    }

    /**
     * test changeTaskStartTime
     */
    @Test
    public void testChangeTaskStartTime(){
        LocalDateTime time = LocalDateTime.of(2021, 11, 22, 9, 30);
        task.changeTaskStartTime(time);
        assertTrue(task.getStartDateTime().isEqual(time));
    }

    /**
     * test changeTaskDuration
     */
    @Test
    public void testChangeTaskDuration(){
        LocalTime time = LocalTime.of(12, 30);
        task.changeTaskDuration(time);
        assertEquals(LocalTime.of(12, 30), task.getDuration());
    }

    /**
     * test durationToInt
     */
    @Test
    public void testDurationToInt(){
        assertSame(9, task.durationToInt());
    }

}