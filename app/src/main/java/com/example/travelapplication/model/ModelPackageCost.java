package com.example.travelapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelPackageCost implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("eventId")
    @Expose
    private String eventId;
    @SerializedName("costPerAdult")
    @Expose
    private String costPerAdult;
    @SerializedName("costPerChild")
    @Expose
    private String costPerChild;
    @SerializedName("includings")
    @Expose
    private String includings;

    public ModelPackageCost(String id, String eventId, String costPerAdult, String costPerChild, String includings) {
        this.id = id;
        this.eventId = eventId;
        this.costPerAdult = costPerAdult;
        this.costPerChild = costPerChild;
        this.includings = includings;
    }

    public ModelPackageCost(String eventId, String costPerAdult, String costPerChild, String includings) {
        this.eventId = eventId;
        this.costPerAdult = costPerAdult;
        this.costPerChild = costPerChild;
        this.includings = includings;
    }

    public ModelPackageCost() {
    }

    protected ModelPackageCost(Parcel in) {
        id = in.readString();
        eventId = in.readString();
        costPerAdult = in.readString();
        costPerChild = in.readString();
        includings = in.readString();
    }

    public static final Creator<ModelPackageCost> CREATOR = new Creator<ModelPackageCost>() {
        @Override
        public ModelPackageCost createFromParcel(Parcel in) {
            return new ModelPackageCost(in);
        }

        @Override
        public ModelPackageCost[] newArray(int size) {
            return new ModelPackageCost[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getCostPerAdult() {
        return costPerAdult;
    }

    public void setCostPerAdult(String costPerAdult) {
        this.costPerAdult = costPerAdult;
    }

    public String getCostPerChild() {
        return costPerChild;
    }

    public void setCostPerChild(String costPerChild) {
        this.costPerChild = costPerChild;
    }

    public String getIncludings() {
        return includings;
    }

    public void setIncludings(String includings) {
        this.includings = includings;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(eventId);
        parcel.writeString(costPerAdult);
        parcel.writeString(costPerChild);
        parcel.writeString(includings);
    }
}
