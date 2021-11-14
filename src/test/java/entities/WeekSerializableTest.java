package entities;

import org.junit.After;
import org.junit.Before;

import java.time.LocalDate;

public class WeekSerializableTest {
    LocalDate startDate;
    WeekSerializable week;

    @Before
    public void setUp() {
        startDate = LocalDate.of(2021, 11, 20);
        week = new WeekSerializable(startDate, 1L);
    }

    @After
    public void tearDown() {
    }
}
