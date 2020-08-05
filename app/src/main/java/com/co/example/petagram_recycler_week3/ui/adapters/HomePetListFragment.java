package com.co.example.petagram_recycler_week3.ui.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.co.example.petagram_recycler_week3.domain.model.Pet;
import com.co.example.petagram_recycler_week3.databinding.FragmentHomePetListBinding;
import com.co.example.petagram_recycler_week3.repository.PetagramDbHelper;

/**
 * Use the {@link HomePetListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePetListFragment extends Fragment {

    private FragmentHomePetListBinding binding;
    private RecyclerView mRecyclerView;

    public HomePetListFragment() {
        // Required empty public constructor
    }

    public static HomePetListFragment newInstance() {
        return new HomePetListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomePetListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = binding.petsMainRecycler;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(new PetsAdapter(PetagramDbHelper.getInstance().getAllPets()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}