package com.csc207.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectHoursResponseTest {
    double minHours;
    double maxHours;
    ProjectHoursResponse project;

    /**
     * Sets up the common variables used in tests.
     */
    @Before
    public void setUp() {
        minHours = 1.0;
        maxHours = 2.0;
        project = new ProjectHoursResponse(minHours, maxHours);
    }
    @After
    public void tearDown() {
    }

    /**
     * Tests the method getMinHours.
     */
    @Test
    public void testGetMinHours(){
        assertEquals(1.0, project.getMinHours());
    }

    /**
     * Tests the method getMaxHours.
     */
    @Test
    public void testGetMaxHours(){
        assertEquals(2.0, project.getMaxHours());
    }

}

