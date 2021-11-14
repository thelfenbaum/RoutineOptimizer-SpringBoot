package com.csc207.cli;

import entities.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertTrue;

public class TaskTest {
    LocalTime duration;
    Task task;
    @Before
    public void setUp() {
        duration = LocalTime.of(4, 30);
        task = new Task("Piano Practice", duration, Long.valueOf("1"));
        }

    @After
    public void tearDown() {
    }

    @Test
    public void testComplete() {
        task.complete();
        assertTrue(task.isCompleted());
    }
}