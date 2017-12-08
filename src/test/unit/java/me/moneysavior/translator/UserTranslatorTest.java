package me.moneysavior.translator;

import me.moneysavior.builder.UserEntityBuilder;
import me.moneysavior.entity.UserEntity;
import me.moneysavior.model.User.UserData.UserAttributes;
import me.moneysavior.model.Users;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTranslatorTest {

    private final UserEntityBuilder userEntityBuilder = new UserEntityBuilder();
    private UserTranslator userTranslator = new UserTranslator();

    @Test
    public void shouldTranslateToUsersCorrectly() throws Exception {
        List<UserEntity> userEntities = of(userEntityBuilder.withDefault().build(),
                userEntityBuilder.withDefault().build());
        Users results = userTranslator.translateToUsers(userEntities);
        UserAttributes userAttributes = results.getData().get(0).getData().getAttributes();

        assertThat(results.getData(), hasSize(2));
        assertThat(userAttributes.getEmail(), is("email"));
        assertThat(userAttributes.getUsername(), is("user1"));
        assertThat(userAttributes.getNickname(), is("nickname"));
        assertThat(userAttributes.getPhoneNumber(), is(1234567));
    }

    @Test
    public void shouldReturnEmptyListWhenTranslateToUsersGivenEmptyUserEntities() throws Exception {
        assertThat(userTranslator.translateToUsers(of()).getData(), hasSize(0));
    }

    @Test
    public void shouldReturnEmptyListWhenTranslateToUsersGivenNullUserEntities() throws Exception {
        assertThat(userTranslator.translateToUsers(null).getData(), hasSize(0));
    }
}