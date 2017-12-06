package me.moneysavior.builder;

import me.moneysavior.entity.UserEntity;

public class UserEntityBuilder {
    private static final int USER_ID = 123;
    private static final String USER_NAME = "user1";
    private static final String EMAIL_ADDRESS = "email";
    private static final String NICKNAME = "nickname";
    private static final int PHONE_NUMBER = 1234567;
    private Integer id;
    private String userName;
    private String email;
    private String nickname;
    private Integer phoneNumber;

    public UserEntity build() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setUserName(userName);
        userEntity.setEmail(email);
        userEntity.setNickname(nickname);
        userEntity.setPhoneNumber(phoneNumber);

        return userEntity;
    }

    public UserEntityBuilder withDefault() {
        this.id = USER_ID;
        this.userName = USER_NAME;
        this.email = EMAIL_ADDRESS;
        this.nickname = NICKNAME;
        this.phoneNumber = PHONE_NUMBER;

        return this;
    }

    public UserEntityBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public UserEntityBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserEntityBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntityBuilder withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public UserEntityBuilder withPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
