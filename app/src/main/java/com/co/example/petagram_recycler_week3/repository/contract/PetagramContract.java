package com.co.example.petagram_recycler_week3.repository.contract;

import android.provider.BaseColumns;

public class PetagramContract {

    private PetagramContract() {
    }

    public static class PetDB implements BaseColumns {
        private PetDB() {
        }

        public static final String TABLE_NAME = "pet";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_IMAGE = "image";
    }

    public static class PetRatingDB implements BaseColumns {
        private PetRatingDB() {
        }

        public static final String TABLE_NAME = "pet_rating";
        public static final String COLUMN_NAME_PET_UUID = "pet_uuid";
        public static final String COLUMN_NAME_RATING = "rating";
    }


}
