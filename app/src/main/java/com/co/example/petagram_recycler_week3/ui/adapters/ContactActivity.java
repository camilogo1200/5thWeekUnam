package com.co.example.petagram_recycler_week3.ui.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.co.example.petagram_recycler_week3.utils.SendMail;
import com.co.example.petagram_recycler_week3.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {

    ActivityContactBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sendEmailButton.setOnClickListener(v -> {
            String email = binding.aboutTvemail.getText().toString();
            String message = binding.aboutTietMessage.getText().toString();
            String subject = "";
            SendMail sm = new SendMail(this, email, "TEST - ANDROID JAVAMAIL", message);
            sm.execute();
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;

    }
}