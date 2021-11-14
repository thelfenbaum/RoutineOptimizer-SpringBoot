package entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class UserTest {
    User user;

    @Before
    public void setUp() {
        user = new User("username", "password");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetUsername(){
        assertSame("username", user.getUsername());
    }

    @Test
    public void testGetPassword(){
        assertSame("password", user.getPassword());
    }
}
