package com.co.example.petagram_recycler_week3.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerCollectionAdapter extends FragmentStateAdapter {


    public ViewPagerCollectionAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = HomePetListFragment.newInstance();
                break;
            case 1:
                fragment = ProfileFragment.newInstance();
                break;
            default:
                fragment = HomePetListFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
