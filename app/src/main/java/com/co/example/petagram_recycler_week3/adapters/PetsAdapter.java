package com.co.example.petagram_recycler_week3.adapters;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.co.example.petagram_recycler_week3.R;
import com.co.example.petagram_recycler_week3.data.Pet;

import java.util.List;

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.ViewHolder> {

    List<Pet> lPets;

    public PetsAdapter(List<Pet> allPets) {
        lPets = allPets;
    }

    @NonNull
    @Override
    public PetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetsAdapter.ViewHolder holder, int position) {

        Pet pet = lPets.get(position);
        Resources r = holder.itemView.getContext().getResources();
        Drawable dr = r.getDrawable(pet.getImage(), null);
        holder.petAvatar.setImageDrawable(dr);
        holder.name.setText(pet.getName());
        holder.rating.setText(String.valueOf(pet.getRating()));
        holder.likeButton.setOnClickListener(v -> {
            if (!holder.rated) {
                pet.setRating(pet.getRating() + 1);
                holder.likeButton.setImageDrawable(r.getDrawable(R.drawable.ic_bone_fill, null));
            } else {
                pet.setRating(pet.getRating() - 1);
                holder.likeButton.setImageDrawable(r.getDrawable(R.drawable.ic_bone, null));
            }
            holder.rating.setText(String.valueOf(pet.getRating()));
            holder.rated = !holder.rated;
        });
    }

    @Override
    public int getItemCount() {
        return lPets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView petAvatar;
        private ImageView likeButton;
        private ImageView ratingIcon;
        private TextView name;
        private TextView rating;
        private boolean rated;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            petAvatar = itemView.findViewById(R.id.pet_image);
            name = itemView.findViewById(R.id.pet_name);
            likeButton = itemView.findViewById(R.id.bone);
            ratingIcon = itemView.findViewById(R.id.rating_icon);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
