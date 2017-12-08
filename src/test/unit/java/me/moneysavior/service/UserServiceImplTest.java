package me.moneysavior.service;

import me.moneysavior.builder.UserEntityBuilder;
import me.moneysavior.dao.UserDao;
import me.moneysavior.entity.UserEntity;
import me.moneysavior.exception.ValidationException;
import me.moneysavior.model.Errors;
import me.moneysavior.model.User;
import me.moneysavior.model.User.UserData;
import me.moneysavior.model.User.UserData.UserAttributes;
import me.moneysavior.model.Users;
import me.moneysavior.translator.UserTranslator;
import me.moneysavior.validator.UserValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String EMAIL_ADDRESS = "email address";
    private final UserEntityBuilder defaultBuilder = new UserEntityBuilder().withDefault();

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Mock
    private UserDao userDao;

    @Mock
    private UserTranslator translator;

    @Mock
    private UserValidator userValidator;
    private final UserEntity createdUserEntity = new UserEntityBuilder().withDefault().build();

    @Test
    public void shouldDelegateToUserDaoToGetUsers() throws Exception {
        when(userDao.getUserEntitiesByEmail(EMAIL_ADDRESS)).thenReturn(of());
        userService.getUsersByEmail(EMAIL_ADDRESS);
        verify(userDao).getUserEntitiesByEmail(EMAIL_ADDRESS);
    }

    @Test
    public void shouldDelegateToUserTranslatorToTranslateEntity() throws Exception {
        List<UserEntity> userEntities = of(defaultBuilder.build());
        when(userDao.getUserEntitiesByEmail(EMAIL_ADDRESS)).thenReturn(userEntities);
        when(translator.translateToUsers(userEntities)).thenReturn(buildUser());
        userService.getUsersByEmail(EMAIL_ADDRESS);
        verify(userDao).getUserEntitiesByEmail(EMAIL_ADDRESS);
        verify(translator).translateToUsers(userEntities);
    }

    @Test
    public void shouldCreateUserSuccessfullyWhenValidatorReturnEmptyList() throws Exception {
        User createUser = new User();
        when(userValidator.validateCreateUser(createUser)).thenReturn(emptyList());
        when(userDao.createUser(createUser)).thenReturn(createdUserEntity);
        when(translator.translateToUser(createdUserEntity)).thenReturn(new User());
        userService.createUser(createUser);
        verify(userValidator).validateCreateUser(createUser);
        verify(userDao).createUser(createUser);
        verify(translator).translateToUser(createdUserEntity);
    }

    @Test(expected = ValidationException.class)
    public void shouldThrowValidationExceptionWhenValidatorReturnErrors() throws Exception {
        User createUser = new User();
        when(userValidator.validateCreateUser(createUser)).thenReturn(of(new Errors()));
        userService.createUser(createUser);
        verify(userValidator).validateCreateUser(createUser);
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
        userData.setAttributes(userAttributes);
        user.setData(userData);

        users.setData(of(user));

        return users;
    }


}