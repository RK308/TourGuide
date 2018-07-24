package com.example.android.tourguide;

public class Place {

    // Place details
    private String mPlaceTitle;
    private String mPlaceDesc;
    private String mWebsite;
    private String mPhone;
    private String mAddress;
    private int mPhotoId;

    public Place(String mPlaceTitle, String mPlaceDesc,
                 String mWebsite, String mPhone,
                 String mAddress, int mPhotoId){
        this.mPlaceTitle = mPlaceTitle;
        this.mPlaceDesc = mPlaceDesc;
        this.mWebsite = mWebsite;
        this.mPhone = mPhone;
        this.mAddress = mAddress;
        this.mPhotoId = mPhotoId;
    }
    // Getter methods to get all the information of the Place
    public String getPlaceTitle() {
        return mPlaceTitle;
    }

    public String getPlaceDesc() {
        return mPlaceDesc;
    }

    public String getPlaceWebsite() {
        return mWebsite;
    }

    public String getPlacePhone() {
        return mPhone;
    }

    public String getPlaceAddress() {
        return mAddress;
    }

    public int getPlacePhotoId() {
        return mPhotoId;
    }
}
