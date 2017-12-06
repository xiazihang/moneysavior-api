package me.moneysavior.repository;

import me.moneysavior.entity.UserEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<UserEntity, Integer> {
    List<UserEntity> findByEmail(String email);
}
