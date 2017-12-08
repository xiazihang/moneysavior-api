package me.moneysavior.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.moneysavior.model.User;
import me.moneysavior.model.Users;
import me.moneysavior.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Search users by email address")
    @RequestMapping(value = "/getUsers", method = GET)
    public ResponseEntity<Users> getUsersByEmail(
            @ApiParam(value = "User's email address")
            @RequestParam(required = false)
            String email) {
        Users users = userService.getUsersByEmail(email);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "create user")
    @RequestMapping(value = "/user", method = POST)
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        return null;
    }
}
