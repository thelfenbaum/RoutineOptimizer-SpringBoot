package com.csc207.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the ConvertTimeAndDouble class.
 */

public class ConvertTimeAndDoubleTest {
    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }

    /**
     * Tests convertDateTimeDouble method from a localDateTime to double.
     */
    @Test
    public void convertDateTimeDoubleTest() {
        LocalDateTime time = LocalDateTime.of(2021, 3, 11, 1, 0);
        assertEquals(1.0, ConvertTimeAndDouble.ConvertDateTimeDouble(time), 0.01);
    }

    /**
     * Tests convertLocalTimeDouble method with a LocalTime to type double.
     */
    @Test
    public void convertLocalTimeDoubleTest() {
        LocalTime time = LocalTime.of(2,0);
        assertEquals(2.0, ConvertTimeAndDouble.ConvertLocalTimeDouble(time), 0.01);
    }

    /**
     * Test convertDoubleToLocalTime method with a double converted to a type LocalTime.
     */
    @Test
    public void convertDoubleToLocalTimeTest() {
        double time = 5.5;
        LocalTime expected = LocalTime.of(5, 30);
        assertEquals(expected, ConvertTimeAndDouble.ConvertDoubleToLocalTime(time));
    }
}