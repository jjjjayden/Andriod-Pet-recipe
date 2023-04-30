package com.example.t1;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ChatGPTService {
    @Headers("Content-Type: application/json")
    @POST("https://api.openai.com/v1/engines/davinci-codex/completions")
    Call<ChatGPTResponse> getRecipe(@Body ChatGPTRequest request, @Header("Authorization") String authHeader);
}


