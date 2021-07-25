package com.demo.app.ws.mobileappws.ui.model.request;

import javax.validation.constraints.*;

public class UserDetailRequestModel {
    @NotNull(message = "First name cannot be null!")
    private String firstName;

    @NotNull(message = "Last name cannot be null!")
    private String lastName;

    @NotNull(message = "Email cannot be null!")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null!")
    @Size(min = 8, max = 16, message = "Password must be equal or greater than 8 characters and less than 16 chars. ")
    private String password;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
