package me.moneysavior.service;

import me.moneysavior.model.Users;

public interface UserService {
    Users getUsersByEmail(String email);
}
