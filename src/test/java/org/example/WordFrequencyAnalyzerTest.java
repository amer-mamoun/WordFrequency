package org.example;
import org.example.impl.WordFrequencyAnalyzerImpl;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyAnalyzerTest {


    @Test
    public void testCalculateHighestFrequency() {
        WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzerImpl();
        String text = "The sun shines over the lake and the clouds shine too";
        int highestFrequency = analyzer.calculateHighestFrequency(text);
        assertEquals(3, highestFrequency);
    }

    @Test
    public void testCalculateFrequencyForWord() {
        WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzerImpl();
        String text = "The sun shines over the lake and the clouds shine too";
        String word = "the";
        int frequencyForWord = analyzer.calculateFrequencyForWord(text, word);
        assertEquals(3, frequencyForWord);
    }

    @Test
    public void testCalculateMostFrequentNWords() {
        WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzerImpl();
        String text = "The sun shines over the lake and the clouds shine too";
        int n = 3;
        List<WordFrequency> mostFrequentWords = analyzer.calculateMostFrequentNWords(text, n);
        assertEquals(3, mostFrequentWords.size());
        assertEquals("the", mostFrequentWords.get(0).getWord());
        assertEquals(3, mostFrequentWords.get(0).getFrequency());
        assertEquals("and", mostFrequentWords.get(1).getWord());
        assertEquals(1, mostFrequentWords.get(1).getFrequency());
        assertEquals("clouds", mostFrequentWords.get(2).getWord());
        assertEquals(1, mostFrequentWords.get(2).getFrequency());
    }

    @Test
    public void testCalculateMostFrequentNWordsWithLargeText() {
        WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzerImpl();
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            textBuilder.append("word ");
        }
        String text = textBuilder.toString();
        int n = 1;
        List<WordFrequency> mostFrequentWords = analyzer.calculateMostFrequentNWords(text, n);
        assertEquals(n, mostFrequentWords.size());
        assertEquals("word", mostFrequentWords.get(0).getWord());
        assertEquals(1000, mostFrequentWords.get(0).getFrequency());
    }
}
