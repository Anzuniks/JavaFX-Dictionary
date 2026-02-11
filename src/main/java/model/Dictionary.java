package model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;


    public Dictionary() {
        this.words = new HashMap<>();

        addWord("Java", "Is a high-level, class-based, object-oriented programming language.");
        addWord("Python", "Is an interpreted, high-level and general-purpose programming language.");

    }

    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);

    }
    public String getMeaning(String word) {
        return words.get(word.toLowerCase());
    }
}