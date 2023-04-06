package com.example.t1;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.databinding.ActivityMainBinding;
import com.example.t1.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//back
        binding.returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        });

// submit and do next
        binding.snextButton.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, PasswordActivity.class);
            startActivity(intent);
        });

//validation
        validationEmail();
        validationSignup();

    }

    private void validationSignup() {
        binding.snextButton.setOnClickListener(v -> {
                    binding.snextButton.setText("");;
                    binding.progressBar.setVisibility(View.VISIBLE);
                }

        );
    }

    //validation Email address
    private void validationEmail() {
        binding.emailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String email = binding.emailInput.getText().toString().trim();
                boolean isValidEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

                if (email.isEmpty()) {
                    binding.emailInputLayout.setError(getString(R.string.error_empty_email));
                } else if (!isValidEmail) {
                    binding.emailInputLayout.setError(getString(R.string.error_invalid_email));
                } else {
                    binding.emailInputLayout.setError(null);
                }
                binding.emailInputLayout.requestFocus();
            }

        });

    }
}
