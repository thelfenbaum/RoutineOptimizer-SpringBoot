package entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testComplete() {
        task.complete();
        assertTrue(task.isCompleted());
    }
    @Test
    public void testGetName(){
        assertSame("Piano Practice", task.getName());
    }

    @Test
    public void testChangeName(){
        task.changeName("Workout");
        assertSame("Workout", task.getName());
    }

    @Test
    public void testGetStartDateTime(){
        LocalDateTime expected;
        expected = LocalDateTime.of(0, 1, 1, 0, 0);
        assertTrue(task.getStartDateTime().isEqual(expected));
    }

    @Test
    public void testGetDuration(){
        assertSame(duration, task.getDuration());
    }

    @Test
    public void testIsCompleted(){
        assertSame(false, task.isCompleted());
    }

    @Test
    public void testChangeStartDateTime(){
        LocalDateTime time;
        time = LocalDateTime.of(2021, 11, 22, 9, 30);
        task.changeStartDateTime(time);
        assertTrue(task.getStartDateTime().isEqual(time));
    }

    @Test
    public void testChangeTaskStartTime(){
        LocalDateTime time = LocalDateTime.of(2021, 11, 22, 9, 30);
        task.changeTaskStartTime(time);
        assertTrue(task.getStartDateTime().isEqual(time));
    }

    @Test
    public void testChangeTaskDuration(){
        LocalTime time = LocalTime.of(12, 30);
        task.changeTaskDuration(time);
        assertSame(LocalTime.of(12, 30), task.getDuration());
    }

    @Test
    public void testDurationToInt(){
        assertSame(9, task.durationToInt());
    }

}