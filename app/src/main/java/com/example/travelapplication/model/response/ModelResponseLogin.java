package com.example.travelapplication.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelResponseLogin {

    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("userPhoneNumber")
    @Expose
    private String userPhoneNumber;


    @SerializedName("userPhotoUrl")
    @Expose
    private String userPhotoUrl;


    @SerializedName("responseCode")
    @Expose
    private int responseCode;

    public ModelResponseLogin(String userName, String userPhoneNumber, String userPhotoUrl, int responseCode) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userPhotoUrl = userPhotoUrl;
        this.responseCode = responseCode;
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

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
