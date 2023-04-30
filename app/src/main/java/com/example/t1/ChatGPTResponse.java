package com.example.t1;

import java.util.List;

public class ChatGPTResponse {
    private List<ChatGPTChoice> choices;

    public List<ChatGPTChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<ChatGPTChoice> choices) {
        this.choices = choices;
    }
}

class ChatGPTChoice {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

