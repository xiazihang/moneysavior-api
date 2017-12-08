package me.moneysavior.controller;

import me.moneysavior.model.Users;
import me.moneysavior.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    private static final String EMAIL_ADDRESS = "email address";
    @InjectMocks
    private UserController userController = new UserController();

    @Mock
    private UserService userService;

    @Test
    public void shouldDelegateToUserServiceToSearchUsers() throws Exception {
        when(userService.getUsersByEmail("email address")).thenReturn(new Users());
        userController.getUsersByEmail("email address");
        verify(userService).getUsersByEmail(EMAIL_ADDRESS);
    }

    @Test
    public void shouldDelegateToUserServiceToCreateUser() throws Exception {

    }
}