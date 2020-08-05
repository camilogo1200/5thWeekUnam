package com.co.example.petagram_recycler_week3.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.co.example.petagram_recycler_week3.R;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pet implements Parcelable {
    private String uuid;
    private String name;
    private int image;
    private int rating;


    public Pet() {
    }

    public Pet(String uuid, String name, int image, int rating) {
        this.uuid = uuid;
        this.name = name;
        this.image = image;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    protected Pet(Parcel in) {
        name = in.readString();
        image = in.readInt();
        rating = in.readInt();
    }

    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in);
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(image);
        dest.writeInt(rating);
    }
}
