package com.example.travelapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelPackageSchedule implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("eventId")
    @Expose
    private String eventId;
    @SerializedName("dayCount")
    @Expose
    private String dayCount;
    @SerializedName("scheculeDetails")
    @Expose
    private String scheculeDetails;

    public ModelPackageSchedule(String id, String eventId, String dayCount, String scheculeDetails) {
        this.id = id;
        this.eventId = eventId;
        this.dayCount = dayCount;
        this.scheculeDetails = scheculeDetails;
    }

    public ModelPackageSchedule(String eventId, String dayCount, String scheculeDetails) {
        this.eventId = eventId;
        this.dayCount = dayCount;
        this.scheculeDetails = scheculeDetails;
    }

    public ModelPackageSchedule() {
    }

    protected ModelPackageSchedule(Parcel in) {
        id = in.readString();
        eventId = in.readString();
        dayCount = in.readString();
        scheculeDetails = in.readString();
    }

    public static final Creator<ModelPackageSchedule> CREATOR = new Creator<ModelPackageSchedule>() {
        @Override
        public ModelPackageSchedule createFromParcel(Parcel in) {
            return new ModelPackageSchedule(in);
        }

        @Override
        public ModelPackageSchedule[] newArray(int size) {
            return new ModelPackageSchedule[size];
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

    public String getDayCount() {
        return dayCount;
    }

    public void setDayCount(String dayCount) {
        this.dayCount = dayCount;
    }

    public String getScheculeDetails() {
        return scheculeDetails;
    }

    public void setScheculeDetails(String scheculeDetails) {
        this.scheculeDetails = scheculeDetails;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(eventId);
        parcel.writeString(dayCount);
        parcel.writeString(scheculeDetails);
    }
}
