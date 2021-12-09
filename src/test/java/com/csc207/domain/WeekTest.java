package com.csc207.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

/**
 * This class tests the Week class.
 */

public class WeekTest {
    Week week;
    LocalDate startDate;

    /**
     * test setup in common for all the tests below
     */
    @Before
    public void setUp() {
        startDate = LocalDate.of(2021, 11, 20);
        week = new Week(1L, DaysInjector.constructDayList(startDate));
    }

    /**
     * tear down after running each test
     */
    @After
    public void tearDown() {
    }

    /**
     * test whether the days in the week are seven days starting with the provided startDate
     */
    @Test
    public void testGetDays(){
        assertEquals(7, week.getDays().length);
    }

    /**
     * confirm that userId in week matches user id
     */
    @Test
    public void testGetUserId(){
        assertSame(1L, week.getUserId());
    }
}
