package entities;

import com.csc207.domain.TaskSerializable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;


public class TaskSerializableTest {
    LocalTime duration;
    LocalDateTime startDateTime;
    TaskSerializable task;

    @Before
    public void setUp() {
        duration = LocalTime.of(4, 30);
        startDateTime = LocalDateTime.of(2021, 12, 1, 9, 0);
        task = new TaskSerializable("Piano Practice", startDateTime, duration, false, 1L);
    }

    @After
    public void tearDown() {
    }

    /**
     * test getName
     */
    @Test
    public void testGetName(){
        assertSame("Piano Practice", task.getName());
    }

    /**
     * test getStartDateTime
     */
    @Test
    public void testGetStartDateTime(){
        LocalDateTime expected = LocalDateTime.of(2021, 12, 1, 9, 0);
        assertEquals(expected, task.getStartDateTime());
    }

    /**
     * test getDuration
     */
    @Test
    public void testGetDuration(){
        LocalTime expected = LocalTime.of(4, 30);
        assertEquals(expected, task.getDuration());
    }

    /**
     * test getUserId
     */
    @Test
    public void testGetUserId(){
        assertSame(1L, task.getUserId());
    }
}
