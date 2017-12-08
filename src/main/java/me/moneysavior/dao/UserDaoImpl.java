package me.moneysavior.dao;

import me.moneysavior.entity.UserEntity;
import me.moneysavior.model.User;
import me.moneysavior.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> getUserEntitiesByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity createUser(User user) {
        return null;
    }
}
