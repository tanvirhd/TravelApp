package com.example.travelapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelTourPackage implements Parcelable {
    @SerializedName("eventId")
    @Expose
    private String eventId;
    @SerializedName("evenName")
    @Expose
    private String evenName;
    @SerializedName("numOfDays")
    @Expose
    private String numOfDays;
    @SerializedName("numberOfNight")
    @Expose
    private String numberOfNight;
    @SerializedName("numberOfPlaces")
    @Expose
    private String numberOfPlaces;
    @SerializedName("eventDetails")
    @Expose
    private String eventDetails;
    @SerializedName("needToCarry")
    @Expose
    private String needToCarry;
    @SerializedName("eventIncludings")
    @Expose
    private String eventIncludings;
    @SerializedName("eventPhotoUrl")
    @Expose
    private String eventPhotoUrl;
    @SerializedName("eventStatus")
    @Expose
    private String eventStatus;
    @SerializedName("eventSchedule")
    @Expose
    private List<ModelPackageSchedule> eventSchedule ;
    @SerializedName("eventfoodCourse")
    @Expose
    private List<ModelPackageFoodCourse> eventFoodCourse ;
    @SerializedName("eventCost")
    @Expose
    private List<ModelPackageCost> eventCost;

    //================================constructor=========================================


    public ModelTourPackage(String eventId,
                            String evenName,
                            String numOfDays,
                            String numberOfNight,
                            String numberOfPlaces,
                            String eventDetails,
                            String needToCarry,
                            String eventIncludings,
                            String eventPhotoUrl,
                            String eventStatus,
                            List<ModelPackageSchedule> eventSchedule,
                            List<ModelPackageFoodCourse> eventFoodCourse,
                            List<ModelPackageCost> eventCost) {
        this.eventId = eventId;
        this.evenName = evenName;
        this.numOfDays = numOfDays;
        this.numberOfNight = numberOfNight;
        this.numberOfPlaces = numberOfPlaces;
        this.eventDetails = eventDetails;
        this.needToCarry = needToCarry;
        this.eventIncludings = eventIncludings;
        this.eventPhotoUrl = eventPhotoUrl;
        this.eventStatus = eventStatus;
        this.eventSchedule = eventSchedule;
        this.eventFoodCourse = eventFoodCourse;
        this.eventCost = eventCost;
    }

    //page 1
    public ModelTourPackage(String eventId, String evenName, String numOfDays, String numberOfNight, String numberOfPlaces, String eventPhotoUrl, String eventStatus) {
        this.eventId = eventId;
        this.evenName = evenName;
        this.numOfDays = numOfDays;
        this.numberOfNight = numberOfNight;
        this.numberOfPlaces = numberOfPlaces;
        this.eventPhotoUrl = eventPhotoUrl;
        this.eventStatus = eventStatus;
    }

    //page 2
    public ModelTourPackage(String eventId, String data,String tag) {

        switch (tag){
            case "details":
                this.eventId = eventId;
                this.eventDetails = data;
                break;
            case "including":
                this.eventId = eventId;
                this.eventIncludings = data;
                break;
            case "needtocarry":
                this.eventId = eventId;
                this.needToCarry = data;
                break;
        }
    }



    //=============================getter setter==========================================

    protected ModelTourPackage(Parcel in) {
        eventId = in.readString();
        evenName = in.readString();
        numOfDays = in.readString();
        numberOfNight = in.readString();
        numberOfPlaces = in.readString();
        eventDetails = in.readString();
        needToCarry = in.readString();
        eventIncludings = in.readString();
        eventPhotoUrl = in.readString();
        eventStatus = in.readString();
        eventSchedule = in.createTypedArrayList(ModelPackageSchedule.CREATOR);
        eventFoodCourse = in.createTypedArrayList(ModelPackageFoodCourse.CREATOR);
        eventCost = in.createTypedArrayList(ModelPackageCost.CREATOR);
    }

    public static final Creator<ModelTourPackage> CREATOR = new Creator<ModelTourPackage>() {
        @Override
        public ModelTourPackage createFromParcel(Parcel in) {
            return new ModelTourPackage(in);
        }

        @Override
        public ModelTourPackage[] newArray(int size) {
            return new ModelTourPackage[size];
        }
    };

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEvenName() {
        return evenName;
    }

    public void setEvenName(String evenName) {
        this.evenName = evenName;
    }

    public String getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(String numOfDays) {
        this.numOfDays = numOfDays;
    }

    public String getNumberOfNight() {
        return numberOfNight;
    }

    public void setNumberOfNight(String numberOfNight) {
        this.numberOfNight = numberOfNight;
    }

    public String getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(String numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getEventIncludings() {
        return eventIncludings;
    }

    public void setEventIncludings(String eventIncludings) {
        this.eventIncludings = eventIncludings;
    }

    public String getNeedToCarry() {
        return needToCarry;
    }

    public void setNeedToCarry(String needToCarry) {
        this.needToCarry = needToCarry;
    }

    public String getEventPhotoUrl() {
        return eventPhotoUrl;
    }

    public void setEventPhotoUrl(String eventPhotoUrl) {
        this.eventPhotoUrl = eventPhotoUrl;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public List<ModelPackageSchedule> getEventSchedule() {
        return eventSchedule;
    }

    public void setEventSchedule(List<ModelPackageSchedule> eventSchedule) {
        this.eventSchedule = eventSchedule;
    }

    public List<ModelPackageFoodCourse> getEventFoodCourse() {
        return eventFoodCourse;
    }

    public void setEventFoodCourse(List<ModelPackageFoodCourse> eventFoodCourse) {
        this.eventFoodCourse = eventFoodCourse;
    }

    public List<ModelPackageCost> getEventCost() {
        return eventCost;
    }

    public void setEventCost(List<ModelPackageCost> eventCost) {
        this.eventCost = eventCost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(eventId);
        parcel.writeString(evenName);
        parcel.writeString(numOfDays);
        parcel.writeString(numberOfNight);
        parcel.writeString(numberOfPlaces);
        parcel.writeString(eventDetails);
        parcel.writeString(needToCarry);
        parcel.writeString(eventIncludings);
        parcel.writeString(eventPhotoUrl);
        parcel.writeString(eventStatus);
        parcel.writeTypedList(eventSchedule);
        parcel.writeTypedList(eventFoodCourse);
        parcel.writeTypedList(eventCost);
    }
}
