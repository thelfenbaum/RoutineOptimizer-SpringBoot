package entities;

import api.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

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
     * test that username matches user.getUsername()
     */
    @Test
    public void testGetUsername(){
        assertSame("username", user.getUsername());
    }

    /**
     * test that password matches user.getPassword()
     */
    @Test
    public void testGetPassword(){
        assertSame("password", user.getPassword());
    }
}
