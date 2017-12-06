package me.moneysavior.translator;

import me.moneysavior.entity.UserEntity;
import me.moneysavior.model.User;
import me.moneysavior.model.User.UserData;
import me.moneysavior.model.User.UserData.UserAttributes;
import me.moneysavior.model.Users;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;
import static org.hibernate.internal.util.collections.CollectionHelper.isNotEmpty;

@Component
public class UserTranslator {
    public Users translateToUsers(List<UserEntity> userEntities) {
        Users users = new Users();
        if (isNotEmpty(userEntities)) {
            List<User> userList = newArrayList();
            userList.addAll(userEntities.stream().map(this::buildUser).collect(toList()));
            users.setData(userList);
        }

        return users;
    }


    public List<UserEntity> translateToUserEntities(List<User> user) {
        return null;
    }

    private User buildUser(UserEntity userEntity) {
        User user = new User();
        UserData userData = new UserData();
        UserAttributes userAttributes = new UserAttributes();
        userAttributes.setEmail(userEntity.getEmail());
        userAttributes.setUsername(userEntity.getUserName());
        userAttributes.setNickname(userEntity.getNickname());
        userAttributes.setPhoneNumber(userEntity.getPhoneNumber());

        userData.setAttributs(userAttributes);
        user.setData(userData);
        return user;
    }
}
