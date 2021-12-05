package com.example.travelapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelImage {
    @SerializedName("photoId")
    @Expose
    private String photoId;
    @SerializedName("eventName")
    @Expose
    private String eventName;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("photoUrl")
    @Expose
    private String photoUrl;

    public ModelImage(String photoId, String eventName, String date, String photoUrl) {
        this.photoId = photoId;
        this.eventName = eventName;
        this.date = date;
        this.photoUrl = photoUrl;
    }

    public ModelImage() {
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
