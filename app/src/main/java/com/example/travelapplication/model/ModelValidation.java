package com.example.travelapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelValidation {

    @SerializedName("isNewUser")
    @Expose
    boolean isNewUser;

    @SerializedName("status")
    @Expose
    int statusCode;

    public ModelValidation(boolean isNewUser, int statusCode) {
        this.isNewUser = isNewUser;
        this.statusCode = statusCode;
    }

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
