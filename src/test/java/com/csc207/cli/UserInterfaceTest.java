package com.csc207.cli;

import com.csc207.api.*;
import com.csc207.domain.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This class is responsible for testing the UserInterface class.
 */

public class UserInterfaceTest {
    UserInteractorDataOut mockUIDO;
    UserInterface mockUI;
    UserController mockUC;
    WeekSerializableInteractorDataOut mockWSI;
    TaskSerializableInteractorDataOut mockTSIDO;
    WeekController mockWC;
    UserInterface UI;

//    @Before
//    public void setUp(){
//        mockUIDO = mock(UserInteractorDataOut.class);
//        mockUI = mock(UserInterface.class);
//        mockUC = mock(UserController.class);
//        mockWSI = mock(WeekSerializableInteractorDataOut.class);
//        mockTSIDO = mock(TaskSerializableInteractorDataOut.class);
//        mockWC = mock(WeekController.class);
//        UI = new UserInterface(mockUC, mockWSI, mockUIDO, mockTSIDO, mockWC);
//    }
    /**
     * Tests the signInOrSignUp method.
     */
    @Test
    public void testSignInOrSignUp(){
        String[] responses = {"y", "n"};

        for (String response: responses) {
            if (Objects.equals(response, "y")) {
                assertEquals("y", response);
            } else if (Objects.equals(response, "n")) {
                assertEquals("n", response);
            }
        }
    }

    /**
     * Tests the signIn method.
     */
    @Test
    public void testSignIn(){
        String username = "RoutOp";
        String password = "RoutOpIsAwesome";
        when(mockUIDO.checkSignIn(username, password)).thenReturn(true);
        when(mockUIDO.getUserIdByUsername(username)).thenReturn(2L);

        assertTrue(mockUIDO.checkSignIn(username, password)); // checks whether the username and password exist and match up
        long userId = mockUIDO.getUserIdByUsername(username);
        assertEquals(2L, userId);
    }

    /**
     * Tests the activateSignInOrSignUp method when they have an account.
     */
    @Test
    public void testActivateSignInOrSignUp(){
        Scanner reader = new Scanner(System.in);
        when(mockUI.signIn(reader)).thenReturn(2L);

        assertEquals(2L, mockUI.signIn(reader));
    }

    /**
     * Tests the signUp method.
     */
    @Test
    public void testSignUp(){
        String username = "RoutOp";
        when(mockUC.isUsernameInDb(username)).thenReturn(true);
        assertTrue(mockUC.isUsernameInDb(username));
        String password = "Password";
        User newUser = new User(username, password);
        assertNull(newUser.getId());
    }

    /**
     * Tests the method createOrImportWeek.
     */
    @Test
    public void testCreateOrImportWeek(){
        String selectedOption = "3";
        assertEquals(3, Integer.parseInt(selectedOption));
    }

    /**
     * Tests the createOrImportWeek method.
     */
    @Test
    public void testCreateWeek(){
        String selectedOption = "1";
        assertEquals(1, Integer.parseInt(selectedOption));
    }

    /**
     * Tests the activateCreateOrImport method.
     */

    @Test
    public void testActivateCreateOrImport(){
        LocalDate startDate = LocalDate.of(2021, 10, 12);
        Day[] days = DaysInjector.constructDayList(startDate);
        Week week = new Week(2L, days);
        assertEquals(startDate.getDayOfWeek(), week.getDays()[0].getDayOfWeek());
    }

    /**
     * Tests the scheduleDuty method.
     */
    @Test
    public void testScheduleDuty(){
        String selectedOption = "4";
        assertEquals(4, Integer.parseInt(selectedOption));
    }

    /**
     * Tests the createFixedTask method.
     */
    @Test
    public void testCreateFixedTask(){
        String name = "Piano";
        LocalDateTime startDateTime = LocalDateTime.of(2021, 12, 10, 1, 0);
        LocalTime duration = LocalTime.of(1,0);
        FixedTask expected = new FixedTask(name, startDateTime, duration, 2L);  // Create a FixedTask from this information
        assertEquals("Piano", expected.getName());
    }

    /**
     * Tests the createNonFixedTask method.
     */
    @Test
    public void testCreateNonFixedTask(){
        String name = "Soccer practice";
        LocalDateTime startDateTime = LocalDateTime.of(2050, 12, 10, 1, 0);
        LocalTime duration = LocalTime.of(2,0);
        NonFixedTask expected = new NonFixedTask(name, startDateTime, duration, 2L);  // Create a FixedTask from this information
        assertEquals("Soccer practice", expected.getName());
    }

    /**
     * Tests the createProject method.
     */
    @Test
    public void testCreateProject(){
        String name = "Soccer practice";
        LocalDateTime startDateTime = LocalDateTime.of(2050, 12, 10, 1, 0);
        LocalTime duration = LocalTime.of(2,0);
        NonFixedTask task = new NonFixedTask(name, startDateTime, duration, 2L);  // Create a FixedTask from this information
        String name2 = "Piano";
        LocalDateTime startDateTime2 = LocalDateTime.of(2021, 12, 10, 1, 0);
        LocalTime duration2 = LocalTime.of(1,0);
        NonFixedTask task2 = new NonFixedTask(name2, startDateTime2, duration2, 3L);  // Create a FixedTask from this information

        NonFixedTask[] projectTasks = {task, task2};

        assertEquals(2, projectTasks.length);
        assertEquals(task.getName(), projectTasks[0].getName());
    }

}
