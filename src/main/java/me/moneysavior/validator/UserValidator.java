package me.moneysavior.validator;

import me.moneysavior.model.Errors;
import me.moneysavior.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class UserValidator {
    public List<Errors> validateCreateUser(User user) {
        return emptyList();
    }
}
