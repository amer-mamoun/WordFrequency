package org.example;


import org.example.impl.WordFrequencyAnalyzerImpl;

import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String text = "The sun shines over the lake and the clouds shine too";

        // Create an instance of WordFrequencyAnalyzer
        WordFrequencyAnalyzerImpl analyzer = new WordFrequencyAnalyzerImpl();

        // Test calculateHighestFrequency method
        int highestFrequency = analyzer.calculateHighestFrequency(text);
        System.out.println("Highest Frequency: " + highestFrequency);

        // Test calculateFrequencyForWord method
        String word = "the";
        int frequencyForWord = analyzer.calculateFrequencyForWord(text, word);
        System.out.println("Frequency for word '" + word + "': " + frequencyForWord);

        // Test calculateMostFrequentNWords method
        int n = 3;
        List<WordFrequency> mostFrequentWords = analyzer.calculateMostFrequentNWords(text, n);
        System.out.println("Most frequent " + n + " words:");
        for (WordFrequency wordFrequency : mostFrequentWords) {
            System.out.println(wordFrequency.getWord() + ": " + wordFrequency.getFrequency());
        }
    }
}
