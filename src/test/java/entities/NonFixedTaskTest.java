package entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertTrue;

public class NonFixedTaskTest {
    LocalTime duration;
    NonFixedTask task;
    LocalDateTime dueDateTime;

    @Before
    public void setUp() {
        duration = LocalTime.of(4, 30);
        dueDateTime = LocalDateTime.of(2021, 11, 22, 9, 30);
        task = new NonFixedTask("Piano Practice", dueDateTime, duration, 1L);
    }

    @After
    public void tearDown() {
    }

    /*
    @Test
    public void testGetDueDateTime() {
        LocalDateTime expected;
        expected = LocalDateTime.of(2021, 11, 22, 9, 30);
        assertTrue(task.getDueDateTime().isEqual(expected));
    }*/

}
