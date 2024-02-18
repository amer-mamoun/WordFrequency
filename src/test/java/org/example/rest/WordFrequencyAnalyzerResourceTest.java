package org.example.rest;


import org.example.WordFrequency;
import org.example.WordFrequencyAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


public class WordFrequencyAnalyzerResourceTest {


    @Mock
    private WordFrequencyAnalyzer analyzer;

    @InjectMocks
    private WordFrequencyAnalyzerResource resource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateHighestFrequency() {
        when(analyzer.calculateHighestFrequency(anyString())).thenReturn(3);
        int frequency = resource.calculateHighestFrequency("This is a test string");
        assertEquals(3, frequency);
    }

    @Test
    public void testCalculateFrequencyForWord() {
        when(analyzer.calculateFrequencyForWord(anyString(), anyString())).thenReturn(2);
        int frequency = resource.calculateFrequencyForWord("This is a test string", "test");
        assertEquals(2, frequency);
    }

    @Test
    public void testCalculateMostFrequentNWords() {
        List<WordFrequency> wordFrequencies = Arrays.asList(
                new ConcreteWordFrequency("the", 3),
                new ConcreteWordFrequency("is", 2),
                new ConcreteWordFrequency("a", 1)
        );
        when(analyzer.calculateMostFrequentNWords(anyString(), eq(3))).thenReturn(wordFrequencies);
        List<WordFrequency> result = resource.calculateMostFrequentNWords("This is a test string", 3);
        assertEquals(wordFrequencies, result);
    }

    private static class ConcreteWordFrequency implements WordFrequency {
        private final String word;
        private final int    frequency;

        public ConcreteWordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public String getWord() {
            return word;
        }

        @Override
        public int getFrequency() {
            return frequency;
        }
    }
}
