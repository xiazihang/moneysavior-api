package me.moneysavior.service;

import me.moneysavior.model.User;
import me.moneysavior.model.Users;

public interface UserService {
    Users getUsersByEmail(String email);

    User createUser(User user);
}
