package Main;

import DataStorage.FileAnalyzer;

/**
 * File Metrics Project in Java. Is meant to guess the size of a 
 * file based upon the input and the file extension and generate summary statistics.
 * @author mullins-dev
 *
 */

public class Main {

	public static void main(String[] args) throws Exception {
		
		FileAnalyzer fa = new FileAnalyzer("replaceme.txt");
		
		fa.readFile();
		
		fa.runStatistics();
		
	}
	
}
