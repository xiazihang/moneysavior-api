package me.moneysavior.dao;

import me.moneysavior.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.collect.ImmutableList.of;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {
    private static final String EMAIL_ADDRESS = "email address";

    @InjectMocks
    private UserDao userDaoImpl = new UserDaoImpl();

    @Mock
    private UserRepository userRepository;

    @Test
    public void shouldDelegateToUserRepositoryToGetUsers() throws Exception {
        when(userRepository.findByEmail(EMAIL_ADDRESS)).thenReturn(of());
        userDaoImpl.getUserEntitiesByEmail("email address");
        verify(userRepository).findByEmail(EMAIL_ADDRESS);
    }
}