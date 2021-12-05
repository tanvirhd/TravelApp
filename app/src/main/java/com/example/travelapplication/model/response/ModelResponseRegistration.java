package com.example.travelapplication.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelResponseRegistration {
    @SerializedName("response")
    @Expose
    private  int response;

    public ModelResponseRegistration(int response) {
        this.response = response;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
