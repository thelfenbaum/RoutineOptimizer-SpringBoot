package entities;

import api.WeekSerializable;
import org.junit.After;
import org.junit.Before;

import java.time.LocalDate;

public class WeekSerializableTest {
    LocalDate startDate;
    WeekSerializable week;

    /**
     * test setup in common for all the tests bellow
     */
    @Before
    public void setUp() {
        startDate = LocalDate.of(2021, 11, 20);
        week = new WeekSerializable(startDate, 1L);
    }

    /**
     * tear down after running each test
     */
    @After
    public void tearDown() {
    }
}
