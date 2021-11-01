package com.example.travelapplication.model;

public class ModelHomeOption {
    private String optionTitle;
    private String optionShortDetails;
    private int optionImage;

    public ModelHomeOption(String optionTitle, String optionShortDetails, int optionImage) {
        this.optionTitle = optionTitle;
        this.optionShortDetails = optionShortDetails;
        this.optionImage = optionImage;
    }

    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    public String getOptionShortDetails() {
        return optionShortDetails;
    }

    public void setOptionShortDetails(String optionShortDetails) {
        this.optionShortDetails = optionShortDetails;
    }

    public int getOptionImage() {
        return optionImage;
    }

    public void setOptionImage(int optionImage) {
        this.optionImage = optionImage;
    }
}
