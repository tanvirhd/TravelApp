package com.example.travelapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelUser {

    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("userPhoneNumber")
    @Expose
    private String userPhoneNumber;

    @SerializedName("userPassword")
    @Expose
    private String userPassword;

    @SerializedName("userPhotoUrl")
    @Expose
    private String userPhotoUrl;

    public ModelUser(String userName, String userPhoneNumber, String userPassword, String userPhotoUrl) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
        this.userPhotoUrl = userPhotoUrl;
    }

    public ModelUser(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public ModelUser(String userPhoneNumber, String userPassword) {
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
    }

    public ModelUser() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }
}
