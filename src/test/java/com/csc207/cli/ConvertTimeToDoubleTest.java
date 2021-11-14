package com.csc207.cli;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class ConvertTimeToDoubleTest {
    ConvertTimeToDouble converter = new ConvertTimeToDouble();
    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }

    @Test
    public void convertDateTimeDouble() {
        LocalDateTime time = LocalDateTime.of(2021, 3, 11, 1, 0);
        assertEquals(1.0, converter.ConvertDateTimeDouble(time), 0.01);
    }

    @Test
    public void convertLocalTimeDouble() {
        LocalTime time = LocalTime.of(2,0);
        assertEquals(2.0, converter.ConvertLocalTimeDouble(time), 0.01);
    }

    @Test
    public void convertDoubleToLocalTime() {
        double time = 5.5;
        LocalTime expected = LocalTime.of(5, 30);
        assertEquals(expected, converter.ConvertDoubleToLocalTime(time));
    }
}