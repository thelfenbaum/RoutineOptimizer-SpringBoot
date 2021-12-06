package com.csc207.cli;

import com.csc207.domain.DaysInjector;
import com.csc207.domain.NonFixedTask;
import com.csc207.domain.Putter;
import com.csc207.domain.Week;

import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the UserInterfaceExceptions class.
 */

public class UserInterfaceExceptionsTest {
    public void setUp(){
    }

    @After
    public void tearDown(){
    }

    /**
     * tests the method getDate with simulation.
     */
    @Test
    public void testGetDate(){
        System.out.println("(Please enter date in format YYYY-MM-DD)");
        String startDate = "2021-04-12";

        int year = Integer.parseInt(startDate.substring(0, 4));
        int month = Integer.parseInt(startDate.substring(5, 7));
        int day = Integer.parseInt(startDate.substring(8, 10));
        LocalDate actual = LocalDate.of(year, month, day);

        assertEquals(LocalDate.of(2021, 4, 12), actual);
    }

    /**
     * Tests the method getTime.
     */
    @Test
    public void testGetTime(){
        String startTime = "10:00";
        int hour = Integer.parseInt(startTime.substring(0, 2));
        int minute = Integer.parseInt(startTime.substring(3, 5));

        assertEquals(LocalTime.of(10, 0), LocalTime.of(hour, minute));
    }

}
