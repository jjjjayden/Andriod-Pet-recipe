package com.example.t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.databinding.ActivityRecipesBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipesActivity extends AppCompatActivity {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/engines/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private ChatGPTService chatGPTService = retrofit.create(ChatGPTService.class);
    private ActivityRecipesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecipesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.inputPetname.getText().toString();
                String weight = binding.inputPetType.getText().toString();
                String Age = binding.inputPetType.getText().toString();
                String ingerdients = binding.inputPetType.getText().toString();
                String type = binding.inputPetType.getText().toString();
                // Handle other input fields...

                String prompt = "请为以下宠物生成一个食谱：种类：" + inputPetType;
                // Add other input fields to the prompt...

                ChatGPTRequest request = new ChatGPTRequest(prompt, 150, 0.7f, 1);
                String authHeader = "Bearer " + "your_api_key_here";
                Call<ChatGPTResponse> call = chatGPTService.getRecipe(request, authHeader);

                call.enqueue(new Callback<ChatGPTResponse>() {
                    @Override
                    public void onResponse(Call<ChatGPTResponse> call, Response<ChatGPTResponse> response) {
                        if (response.isSuccessful()) {
                            ChatGPTResponse chatGPTResponse = response.body();
                            String recipeText = chatGPTResponse.getChoices().get(0).getText();

                            Intent intent = new Intent(RecipesActivity.this, RecipeActivity.class);
                            intent.putExtra("recipe", recipeText.trim());
                            startActivity(intent);
                        } else {
                            Toast.makeText(RecipesActivity.this, "请求失败: " + response.errorBody(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ChatGPTResponse> call, Throwable t) {
                        Toast.makeText(RecipesActivity.this, "请求错误: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
