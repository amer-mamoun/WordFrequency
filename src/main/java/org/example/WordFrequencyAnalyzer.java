package org.example;


import java.util.List;


public interface WordFrequencyAnalyzer {

    int calculateFrequencyForWord(String text, String word);
    int calculateHighestFrequency(String text);
    List<WordFrequency> calculateMostFrequentNWords(String text, int n);
}
