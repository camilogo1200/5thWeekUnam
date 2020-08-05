package com.co.example.petagram_recycler_week3.ui.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.co.example.petagram_recycler_week3.R;
import com.co.example.petagram_recycler_week3.domain.model.Pet;
import com.co.example.petagram_recycler_week3.databinding.FragmentProfileBinding;

import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    RecyclerView recyclerView;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Pet> lPets = getPetList();
        recyclerView = binding.recyclerProfilePictures;
        recyclerView.setAdapter(new PetsAdapter(lPets));
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
    }

    @NotNull
    private List<Pet> getPetList() {
        List<Pet> lPets = new ArrayList<>();
        Random rnd = new SecureRandom();
        for (int i = 0; i < 15; i++) {
            lPets.add(new Pet(UUID.randomUUID().toString(), "", R.drawable.daniel_lincoln_l4huaynizky_unsplash, rnd.nextInt(200)))
            ;
        }
        return lPets;
    }
}