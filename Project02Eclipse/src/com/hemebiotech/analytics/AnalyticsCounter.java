package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Aymeric Mary
 * This application allows to write in a file, the frequencies of each symptom contained in another file
 */
public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		ISymptomReader symptomReader = new ReadSymptoms("symptoms.txt");
		List<String> symptoms = symptomReader.getSymptoms();

		Map<String, Integer> symptomsFrequencies = getFrequencies(symptoms);

		ISymptomWriter writer = new WriteSymptoms(symptomsFrequencies);

		writer.writeSymptomsFrequencies();
	}

	/**
	 * @param symptoms The list of symptoms
	 * @return The Map conained frequencies of each symptom
	 */
	private static Map<String, Integer> getFrequencies(List<String> symptoms) {
		Map<String, Integer> frequencies = new TreeMap<>();
		for (String symptom : symptoms) {
			frequencies.put(symptom, Collections.frequency(symptoms, symptom));
		}
		return frequencies;
	}
}
