package me.moneysavior.service;

import me.moneysavior.dao.UserDao;
import me.moneysavior.entity.UserEntity;
import me.moneysavior.exception.ValidationException;
import me.moneysavior.model.Errors;
import me.moneysavior.model.User;
import me.moneysavior.model.Users;
import me.moneysavior.translator.UserTranslator;
import me.moneysavior.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTranslator translator;

    @Autowired
    private UserValidator userValidator;

    @Override
    public Users getUsersByEmail(String email) {
        return translator.translateToUsers(userDao.getUserEntitiesByEmail(email));
    }

    @Override
    public User createUser(User user) {
        List<Errors> errors = userValidator.validateCreateUser(user);
        if (!isEmpty(errors)) {
            throw new ValidationException("Validation Error");
        }
        UserEntity createdUserEntity = userDao.createUser(user);
        return translator.translateToUser(createdUserEntity);
    }
}
