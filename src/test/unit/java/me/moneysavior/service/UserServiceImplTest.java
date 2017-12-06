package me.moneysavior.service;

import me.moneysavior.builder.UserEntityBuilder;
import me.moneysavior.dao.UserDao;
import me.moneysavior.entity.UserEntity;
import me.moneysavior.model.User;
import me.moneysavior.model.User.UserData;
import me.moneysavior.model.User.UserData.UserAttributes;
import me.moneysavior.model.Users;
import me.moneysavior.translator.UserTranslator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String EMAIL_ADDRESS = "email address";
    private final UserEntityBuilder defaultBuilder = new UserEntityBuilder().withDefault();

    @InjectMocks
    private UserService userServiceImpl = new UserServiceImpl();

    @Mock
    private UserDao userDao;

    @Mock
    private UserTranslator translator;

    @Test
    public void shouldDelegateToUserDaoToGetUsers() throws Exception {
        when(userDao.getUserEntitiesByEmail(EMAIL_ADDRESS)).thenReturn(of());
        userServiceImpl.getUsersByEmail(EMAIL_ADDRESS);
        verify(userDao).getUserEntitiesByEmail(EMAIL_ADDRESS);
    }

    @Test
    public void shouldDelegateToUserTranslatorToTranslateEntity() throws Exception {
        List<UserEntity> userEntities = of(defaultBuilder.build());
        when(userDao.getUserEntitiesByEmail(EMAIL_ADDRESS)).thenReturn(userEntities);
        when(translator.translateToUsers(userEntities)).thenReturn(buildUser());
        userServiceImpl.getUsersByEmail(EMAIL_ADDRESS);
        verify(userDao).getUserEntitiesByEmail(EMAIL_ADDRESS);
        verify(translator).translateToUsers(userEntities);
    }

    private Users buildUser() {
        Users users = new Users();
        User user = new User();
        UserAttributes userAttributes = new UserAttributes();
        userAttributes.setUsername("user name");
        userAttributes.setEmail("email");
        userAttributes.setNickname("nickname");
        userAttributes.setPhoneNumber(123456);
        UserData userData = new UserData();
        userData.setAttributs(userAttributes);
        user.setData(userData);

        users.setData(of(user));

        return users;
    }


}