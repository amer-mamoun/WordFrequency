package org.example.impl;


import org.example.WordFrequency;
import org.example.WordFrequencyAnalyzer;
import java.util.*;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {
    @Override
    public int calculateFrequencyForWord(String text, String word) {
        String lowerCaseWord = word.toLowerCase();
        String[] words = text.split("[^a-zA-Z]+");
        int frequency = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(lowerCaseWord)) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    public int calculateHighestFrequency(String text) {
        String[] words = text.split("[^a-zA-Z]+");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            frequencyMap.put(lowerCaseWord, frequencyMap.getOrDefault(lowerCaseWord, 0) + 1);
        }
        return frequencyMap.values().stream().max(Integer::compareTo).orElse(0);
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        String[] words = text.split("[^a-zA-Z]+");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            frequencyMap.put(lowerCaseWord, frequencyMap.getOrDefault(lowerCaseWord, 0) + 1);
        }
        List<WordFrequency> wordFrequencies = new ArrayList<>();
        frequencyMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(n)
                    .forEach(entry -> wordFrequencies.add(new WordFrequencyImpl(entry.getKey(), entry.getValue())));
        return wordFrequencies;
    }
}
