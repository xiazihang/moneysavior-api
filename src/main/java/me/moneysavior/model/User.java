package me.moneysavior.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@ApiModel
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @NotNull
    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public static class UserData {
        @NotNull
        private UserAttributes attributes;

        public UserAttributes getAttributes() {
            return attributes;
        }

        public void setAttributes(UserAttributes attributes) {
            this.attributes = attributes;
        }

        public static class UserAttributes {
            @ApiModelProperty(value = "user's name")
            private String username;
            @ApiModelProperty(value = "user's email")
            private String email;
            @ApiModelProperty(value = "user's nickname")
            private String nickname;
            @ApiModelProperty(value = "user's phone number")
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
