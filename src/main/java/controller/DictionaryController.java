package controller;

import model.Dictionary;

public class DictionaryController {

    private Dictionary model;

    public DictionaryController() {
        this.model = new Dictionary();
    }

    public String searchWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "Please enter a valid word.";
        }

        String meaning = model.getMeaning(word.trim());

        if (meaning == null) {
            return "Word'" + word + "' not found in the dictionary";
    }
        return meaning;
    }
}