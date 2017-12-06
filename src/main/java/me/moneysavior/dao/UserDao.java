package me.moneysavior.dao;

import me.moneysavior.entity.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> getUserEntitiesByEmail(String email);
}
