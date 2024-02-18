package org.example.rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.WordFrequency;
import org.example.WordFrequencyAnalyzer;

import java.util.List;

@RequestScoped
@Path("/wordFrequencyAnalyzer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WordFrequencyAnalyzerResource {


    private final WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @Inject
    public WordFrequencyAnalyzerResource(WordFrequencyAnalyzer wordFrequencyAnalyzer) {
        this.wordFrequencyAnalyzer = wordFrequencyAnalyzer;
    }

    @GET
    @Path("/calculateHighestFrequency")
    public int calculateHighestFrequency(@QueryParam("text") String text) {
        return wordFrequencyAnalyzer.calculateHighestFrequency(text);
    }

    @GET
    @Path("/calculateFrequencyForWord")
    public int calculateFrequencyForWord(@QueryParam("text") String text, @QueryParam("word") String word) {
        return wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);
    }

    @GET
    @Path("/calculateMostFrequentNWords")
    public List<WordFrequency> calculateMostFrequentNWords(@QueryParam("text") String text, @QueryParam("n") int n) {
        return wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n);
    }
}
