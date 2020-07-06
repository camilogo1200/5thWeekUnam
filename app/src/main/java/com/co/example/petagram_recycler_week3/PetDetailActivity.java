package com.co.example.petagram_recycler_week3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.co.example.petagram_recycler_week3.adapters.PetsAdapter;
import com.co.example.petagram_recycler_week3.data.Pet;
import com.co.example.petagram_recycler_week3.databinding.ActivityPetDetailBinding;

import java.util.List;

public class PetDetailActivity extends AppCompatActivity {

    private ActivityPetDetailBinding binding;
    private RecyclerView topPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPetDetailBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        //ActionBar
        setSupportActionBar(findViewById(R.id.actionbar));
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
        //recycler
        topPets = binding.petsRatedRecycler;
        topPets.setLayoutManager(new LinearLayoutManager(this));
        topPets.setAdapter(new PetsAdapter(Pet.getAllPets()));

        //bar.setDisplayUseLogoEnabled(true);
    }
}