package com.example.subramanyam.reciep;

import android.os.Parcel;
import android.os.Parcelable;

public class IndegrientData implements Parcelable{

    int quantity;
    String measure;
    String ingredient;

    public IndegrientData()
    {

    }
    protected IndegrientData(Parcel parcel) {
        this.quantity=parcel.readInt();
        this.measure=parcel.readString();
        this.ingredient=parcel.readString();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }



    public String getIngredient() {
        return ingredient;
    }
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public static final Creator<IndegrientData> CREATOR = new Creator<IndegrientData>() {
        @Override
        public IndegrientData createFromParcel(Parcel in) {
            return new IndegrientData(in);
        }

        @Override
        public IndegrientData[] newArray(int size) {
            return new IndegrientData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.quantity);
        parcel.writeString(this.measure);
        parcel.writeString(this.ingredient);
    }
}
