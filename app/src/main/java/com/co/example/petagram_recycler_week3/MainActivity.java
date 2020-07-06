package com.co.example.petagram_recycler_week3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.co.example.petagram_recycler_week3.adapters.PetsAdapter;
import com.co.example.petagram_recycler_week3.data.Pet;
import com.co.example.petagram_recycler_week3.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ActivityMainBinding binding;
    private AppCompatImageView starImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        mRecyclerView = binding.petsMainRecycler;
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Pet> allPets = Pet.getAllPets();
        mAdapter = new PetsAdapter(allPets);
        mRecyclerView.setAdapter(mAdapter);

        setSupportActionBar(findViewById(R.id.actionbar));
        ActionBar bar = getSupportActionBar();
        //bar.setLogo(R.drawable.ic_pet);
        bar.setDisplayShowTitleEnabled(false);
        //bar.setTitle(R.string.app_name);
        //bar.setDisplayHomeAsUpEnabled(true);
        //bar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_pet, null));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_star:
                Intent intent = new Intent(this, PetDetailActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}