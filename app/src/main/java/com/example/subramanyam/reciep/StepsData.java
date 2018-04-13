package com.example.subramanyam.reciep;

import android.os.Parcel;
import android.os.Parcelable;

public class StepsData implements Parcelable {


    int id;
    String shortDescription;
    String description;
    String videoURL;
    String thumbnailURL;

    public StepsData(){

    }

    protected StepsData(Parcel parcel) {
        this.shortDescription=parcel.readString();
        this.description=parcel.readString();
        this.videoURL=parcel.readString();
        this.thumbnailURL=parcel.readString();

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;

    }


    public static final Creator<StepsData> CREATOR = new Creator<StepsData>() {
        @Override
        public StepsData createFromParcel(Parcel in) {
            return new StepsData(in);
        }

        @Override
        public StepsData[] newArray(int size) {
            return new StepsData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.id);
            parcel.writeString(this.shortDescription);
            parcel.writeString(this.description);
            parcel.writeString(this.videoURL);
            parcel.writeString(this.thumbnailURL);
        }
    }

