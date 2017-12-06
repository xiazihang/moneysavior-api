package me.moneysavior.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public static class UserData {
        private UserAttributes attributs;

        public UserAttributes getAttributs() {
            return attributs;
        }

        public void setAttributs(UserAttributes attributs) {
            this.attributs = attributs;
        }

        public static class UserAttributes {
            private String username;
            private String email;
            private String nickname;
            private Integer phoneNumber;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public Integer getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(Integer phoneNumber) {
                this.phoneNumber = phoneNumber;
            }
        }
    }
}
