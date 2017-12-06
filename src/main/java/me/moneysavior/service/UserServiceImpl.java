package me.moneysavior.service;

import me.moneysavior.dao.UserDao;
import me.moneysavior.model.Users;
import me.moneysavior.translator.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDaoimpl;

    @Autowired
    private UserTranslator translator;

    @Override
    public Users getUsersByEmail(String email) {
        return translator.translateToUsers(userDaoimpl.getUserEntitiesByEmail(email));
    }
}
