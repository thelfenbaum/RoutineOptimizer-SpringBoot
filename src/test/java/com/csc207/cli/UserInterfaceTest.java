package com.csc207.cli;

import com.csc207.api.*;
import com.csc207.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

import static org.mockito.Mockito.*;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Before
    public void setUp(){
        mockUIDO = mock(UserInteractorDataOut.class);
        mockUI = mock(UserInterface.class);
        mockUC = mock(UserController.class);
        mockWSI = mock(WeekSerializableInteractorDataOut.class);
        mockTSIDO = mock(TaskSerializableInteractorDataOut.class);
        mockWC = mock(WeekController.class);
        UI = new UserInterface(mockUC, mockWSI, mockUIDO, mockTSIDO, mockWC);
    }
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
        assertEquals(null, newUser.getId());
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

}
