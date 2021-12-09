package com.csc207.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertNull;

/**
 * This class test the WeekSerializable class.
 */

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

    /**
     * tests the getId method.
     */
    @Test
    public void testGetId(){
        assertNull(week.getId());
    }
}
