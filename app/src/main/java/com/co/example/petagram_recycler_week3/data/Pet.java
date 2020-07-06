package com.co.example.petagram_recycler_week3.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.co.example.petagram_recycler_week3.R;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pet implements Parcelable {
    private String name;
    private int image;
    private int rating;

    private static int[] petImages = {
            R.drawable.charles_deluvio_k4msj7kc0as_unsplash,
            R.drawable.charles_fair_yjfcqvivjdg_unsplash,
            R.drawable.chloe_arquelada_mzf9u0xzsk4_unsplash,
            R.drawable.daniel_lincoln_l4huaynizky_unsplash,
            R.drawable.evelyn_cespedes_vkooysczgkm_unsplash
    };

    public static List<Pet> getAllPets() {
        List<Pet> lPets = new ArrayList<>();
        Random rnd = new SecureRandom();

        for (int i = 0; i < Pet.petImages.length; i++) {
            lPets.add(new Pet("pet " + (i + 1), Pet.petImages[i], rnd.nextInt(200)))
            ;
        }
        return lPets;
    }

    public Pet() {
    }

    public Pet(String name, int image, int rating) {
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
