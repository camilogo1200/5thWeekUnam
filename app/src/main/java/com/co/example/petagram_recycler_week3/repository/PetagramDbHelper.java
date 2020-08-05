package com.co.example.petagram_recycler_week3.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.co.example.petagram_recycler_week3.R;
import com.co.example.petagram_recycler_week3.domain.model.Pet;
import com.co.example.petagram_recycler_week3.domain.model.Petagram;
import com.co.example.petagram_recycler_week3.repository.contract.PetagramContract.PetDB;
import com.co.example.petagram_recycler_week3.repository.contract.PetagramContract.PetRatingDB;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PetagramDbHelper extends SQLiteOpenHelper {

    private static PetagramDbHelper dbHelper = null;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Petagram.db";

    private static final String SQL_CREATE_PETS =
            "CREATE TABLE " + PetDB.TABLE_NAME + " (" +
                    PetDB._ID + " TEXT PRIMARY KEY," +
                    PetDB.COLUMN_NAME_NAME + " TEXT," +
                    PetDB.COLUMN_NAME_IMAGE + " INT)";

    private static final String SQL_CREATE_PET_LIKES =
            "CREATE TABLE " + PetRatingDB.TABLE_NAME + " (" +
                    PetRatingDB._ID + " TEXT PRIMARY KEY, " +
                    PetRatingDB.COLUMN_NAME_PET_UUID + " TEXT ," +
                    PetRatingDB.COLUMN_NAME_RATING + " INT," +
                    " FOREIGN KEY (" + PetRatingDB.COLUMN_NAME_PET_UUID + ") " +
                    " REFERENCES " + PetDB.TABLE_NAME + " (" + PetDB._ID + ")); ";

    public static PetagramDbHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new PetagramDbHelper(Petagram.getInstance().getApplicationContext());
        }
        return dbHelper;
    }

    public PetagramDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PETS);
        db.execSQL(SQL_CREATE_PET_LIKES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// not needed
    }

    private static int[] petImages = {
            R.drawable.charles_deluvio_k4msj7kc0as_unsplash,
            R.drawable.charles_fair_yjfcqvivjdg_unsplash,
            R.drawable.chloe_arquelada_mzf9u0xzsk4_unsplash,
            R.drawable.daniel_lincoln_l4huaynizky_unsplash,
            R.drawable.evelyn_cespedes_vkooysczgkm_unsplash
    };

    public static void initDatabase() {
        SQLiteDatabase database = getInstance().getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i = 0; i < petImages.length; i++) {
            values.put(PetDB._ID, UUID.randomUUID().toString());
            values.put(PetDB.COLUMN_NAME_NAME, "Pet " + (i + 1));
            values.put(PetDB.COLUMN_NAME_IMAGE, petImages[i]);
            database.insert(PetDB.TABLE_NAME, null, values);
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> lPets = new ArrayList<>();

        String[] projection = {
                BaseColumns._ID,
                PetDB.COLUMN_NAME_NAME,
                PetDB.COLUMN_NAME_IMAGE
        };

        SQLiteDatabase db = getInstance().getReadableDatabase();
        Cursor cursor = db.query(PetDB.TABLE_NAME, projection, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String uuid = cursor.getString(cursor.getColumnIndexOrThrow(PetDB._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(PetDB.COLUMN_NAME_NAME));
            int image = cursor.getInt(cursor.getColumnIndexOrThrow(PetDB.COLUMN_NAME_IMAGE));
            lPets.add(new Pet(uuid,name,image,0));
            Log.d("CURSOR", uuid);
        }
        cursor.close();
        return lPets;
    }
}
