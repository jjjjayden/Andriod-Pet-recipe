package com.example.t1;

public class ChatGPTRequest {
    private String prompt;
    private int max_tokens;
    private float temperature;
    private int n;

    public ChatGPTRequest(String prompt, int max_tokens, float temperature, int n) {
        this.prompt = prompt;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
        this.n = n;
    }

    // Getters and setters...
}

