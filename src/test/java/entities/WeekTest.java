package entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertSame;

public class WeekTest {
    Week week;
    LocalDate startDate;

    @Before
    public void setUp() {
        startDate = LocalDate.of(2021, 11, 20);
        week = new Week(startDate, 1L);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testToString(){
    }

    @Test
    public void testGetDays(){
        Day[] days = new Day[7];
        for(int i = 0; i <= 6; i++){
            days[i] = new Day(startDate.plusDays(i));
        }
        assertSame(days, week.getDays());
    }

    @Test
    public void testGetUserId(){
        assertSame(1L, week.getUserId());
    }
}
