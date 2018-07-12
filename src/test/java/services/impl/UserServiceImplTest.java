package services.impl;

import org.junit.Test;
import services.UserService;

import static org.junit.Assert.assertEquals;

/**
 * Created by kopuz on 7/12/2018.
 */
public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void testCreateUserList() throws Exception {

        assertEquals(userService.createUserList().size(),2);
        assertEquals(userService.createUserList().get(0).getUserName(),"alper");
        assertEquals(userService.createUserList().get(1).getUserName(),"connor");
    }
}