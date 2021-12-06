package com.csc207.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * This class tests the User class.
 */

public class UserTest {
    User user;

    /**
     * test setup in common for all the tests bellow
     */
    @Before
    public void setUp() {
        user = new User("username", "password");
    }

    /**
     * tear down after running each test
     */
    @After
    public void tearDown() {
    }

    /**
     * tests the getId method
     */
    @Test
    public void testGetId(){
        assertSame(null, user.getId());
    }

    /**
     * test that password matches user.getPassword()
     */
    @Test
    public void testGetPassword(){
        assertSame("password", user.getPassword());
    }

}
