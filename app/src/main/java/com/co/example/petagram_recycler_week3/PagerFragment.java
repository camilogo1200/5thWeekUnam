package com.co.example.petagram_recycler_week3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.co.example.petagram_recycler_week3.adapters.ViewPagerCollectionAdapter;
import com.co.example.petagram_recycler_week3.databinding.FragmentPagerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagerFragment extends Fragment {

    private FragmentPagerBinding binding;
    private ViewPager2 viewPager;
    private ViewPagerCollectionAdapter collectionAdapter;

    public PagerFragment() {
        // Required empty public constructor
    }

    public static PagerFragment newInstance(String param1, String param2) {
        return new PagerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPagerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        collectionAdapter = new ViewPagerCollectionAdapter(this);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(collectionAdapter);

        TabLayout tabLayout = binding.tabLayout;
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setIcon(R.drawable.ic_baseline_home_24);
                            break;
                        case 1:
                            tab.setIcon(R.drawable.ic_pet);
                    }
                }
        ).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}