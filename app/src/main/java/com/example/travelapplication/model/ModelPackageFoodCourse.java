package com.example.travelapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelPackageFoodCourse implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("eventId")
    @Expose
    private String eventId;
    @SerializedName("dayCount")
    @Expose
    private String dayCount;
    @SerializedName("breakfast")
    @Expose
    private String breakfast;
    @SerializedName("lunch")
    @Expose
    private String lunch;
    @SerializedName("dinner")
    @Expose
    private String dinner;

    public ModelPackageFoodCourse(String id, String eventId, String dayCount, String breakfast, String lunch, String dinner) {
        this.id = id;
        this.eventId = eventId;
        this.dayCount = dayCount;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public ModelPackageFoodCourse(String eventId, String dayCount, String breakfast, String lunch, String dinner) {
        this.eventId = eventId;
        this.dayCount = dayCount;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public ModelPackageFoodCourse() {
    }

    protected ModelPackageFoodCourse(Parcel in) {
        id = in.readString();
        eventId = in.readString();
        dayCount = in.readString();
        breakfast = in.readString();
        lunch = in.readString();
        dinner = in.readString();
    }

    public static final Creator<ModelPackageFoodCourse> CREATOR = new Creator<ModelPackageFoodCourse>() {
        @Override
        public ModelPackageFoodCourse createFromParcel(Parcel in) {
            return new ModelPackageFoodCourse(in);
        }

        @Override
        public ModelPackageFoodCourse[] newArray(int size) {
            return new ModelPackageFoodCourse[size];
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

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
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
        parcel.writeString(breakfast);
        parcel.writeString(lunch);
        parcel.writeString(dinner);
    }
}
