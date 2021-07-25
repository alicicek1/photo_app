package com.demo.app.ws.mobileappws.ui.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailRequestModel {
    @NotNull(message = "First name cannot be null!")
    private String firstName;

    @NotNull(message = "Last name cannot be null!")
    private String lastName;

    @NotNull(message = "UserId cannot be null for update statement!")
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
