package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author Aymeric Mary
 */
public class WriteSymptoms implements ISymptomWriter {

    private Map<String,Integer> frequencies;

    /**
     * @param frequencies A Map with name of symptom for key and frequencies for value
     */
    WriteSymptoms(Map<String,Integer> frequencies){
        this.frequencies = frequencies;
    }

    /**
     * Write in the file result.out, the frequencies of each symptom
     * sorted by alphabetical order
     *
     * @throws IOException
     */
    @Override
    public void writeSymptomsFrequencies() throws IOException {
        FileWriter writer = new FileWriter ("result.out");
        frequencies.forEach((key,value)->{
            try {
                writer.write(key+": " + value + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }
}
