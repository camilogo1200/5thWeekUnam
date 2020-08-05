package com.co.example.petagram_recycler_week3.ui.adapters;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.co.example.petagram_recycler_week3.R;
import com.co.example.petagram_recycler_week3.domain.model.Pet;
import com.co.example.petagram_recycler_week3.databinding.ActivityPetDetailBinding;
import com.co.example.petagram_recycler_week3.repository.PetagramDbHelper;

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
        topPets.setAdapter(new PetsAdapter(PetagramDbHelper.getInstance().getAllPets()));

        //bar.setDisplayUseLogoEnabled(true);
    }
}