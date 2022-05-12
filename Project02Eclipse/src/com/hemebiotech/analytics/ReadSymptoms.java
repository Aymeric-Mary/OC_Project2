package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aymeric Mary
 */
public class ReadSymptoms implements ISymptomReader {

	private String filepath;
	
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptoms(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @return The list of all symptoms in the file
	 * @throws IOException
	 */
	@Override
	public List<String> getSymptoms() throws IOException {
		ArrayList<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try {
				Reader reader = new FileReader(filepath);
				BufferedReader bufferedReader = new BufferedReader (reader);
				String line = bufferedReader.readLine();
				
				while (line != null) {
					result.add(line);
					line = bufferedReader.readLine();
				}
				reader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
