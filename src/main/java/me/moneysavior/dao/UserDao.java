package me.moneysavior.dao;

import me.moneysavior.entity.UserEntity;
import me.moneysavior.model.User;

import java.util.List;

public interface UserDao {
    List<UserEntity> getUserEntitiesByEmail(String email);

    UserEntity createUser(User user);
}
