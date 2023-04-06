package com.example.t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.databinding.ActivityPasswordBinding;

public class PasswordActivity extends AppCompatActivity {
    private ActivityPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.pbackButton.setOnClickListener(v -> {
            Intent intent = new Intent(PasswordActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }
}
