package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * Anything that will write symptoms frequencies to a file
 */
public interface ISymptomWriter {
	void writeSymptomsFrequencies () throws IOException;
}
