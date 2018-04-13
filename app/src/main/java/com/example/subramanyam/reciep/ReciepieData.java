package com.example.subramanyam.reciep;

import android.os.Parcel;
import android.os.Parcelable;

public class ReciepieData implements Parcelable {
int id;
String name;
String ingridients;

String steps;

    public int content;

    public ReciepieData()
{

}

    protected ReciepieData(Parcel parcel) {
this.id=parcel.readInt();
this.name=parcel.readString();
this.ingridients=parcel.readString();

this.steps=parcel.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }




    public static final Creator<ReciepieData> CREATOR = new Creator<ReciepieData>() {
        @Override
        public ReciepieData createFromParcel(Parcel in) {
            return new ReciepieData(in);
        }

        @Override
        public ReciepieData[] newArray(int size) {
            return new ReciepieData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.ingridients);

        parcel.writeString(this.steps);

    }
}
