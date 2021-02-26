package DataStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * File Analyzer class which will analyze a file. Is of type FileStorage.
 * @author mullins-dev
 *
 */
public class FileAnalyzer implements FileStorage {

	private String filename;
	private String extension;
	private Set<String> words;
	private int bytes;
	private double numSpaces;
	private double totalLength;
	private final DecimalFormat percForm = new DecimalFormat("#.##");
	
	/**
	 * Constructs a FileAnalyzer based upon a given filename
	 * @param filename the name of the desired file
	 * @throws FileNotFoundException if the file is invalid
	 */
	public FileAnalyzer(String filename) throws FileNotFoundException {
		if (filename == null || filename.trim().equals("")) {
			throw new FileNotFoundException("Invalid file provided. Please try again.");
		}
		this.filename = filename;	
		this.words = new HashSet<>();
	}
	
	
	/**
	 * Determines how many words are in a given file
	 * @return number of words in the file
	 */
	public void getWords() {
		if (this.words.isEmpty()) {
			System.out.println("Error: You must call readFile() before you request word count.");
		} else {
			System.out.println(this.words.size());
		}
	}

	/**
	 * Determines what type of file is being read
	 * @return the file type of the input file
	 */
	public void getExtension() {
		if (this.words.isEmpty()) {
			System.out.println("Error: You must call readFile() before you request the file extension.");
		} else {
			System.out.println(this.extension);
		}
	}

	/**
	 * Attempts to read from the file. Throws an Input/Output exception
	 * if the given file cannot be read from (i.e. a .ipynb file)
	 * @throws IOException 
	 */
	public void readFile() throws IOException {
		this.extension = filename.substring(filename.indexOf("."));
		
		if (extension.equals(".txt")) {
			Scanner s = new Scanner(new File(filename));
		
			while (s.hasNext()) {
				String temp = s.nextLine();	
				this.totalLength += temp.length();
				String[] inputArray = temp.split(" ");
				this.numSpaces += inputArray.length - 1;
				bytes += temp.length(); // Add the number of spaces between each word as a character.
				
				for (String word : inputArray) {
					this.words.add(word);
				}
			}
			System.out.println("File reading complete!");
			s.close(); // Close the resource
		} else {
			throw new IOException("File with extension " + extension + " cannot be read. Try again with a .txt file.");
		}
	
	}

	/**
	 * Representation of what the implementer deems to be summary statistics for a file
	 */
	public void runStatistics() {
		String intro = "Basic Analysis of: " + this.filename + ":"; 
		String byteData = "\tEstimated size: " + this.bytes + " bytes.";
		String numWords = "\tNumber of words: " + this.words.size() + ".";
		String spacePct = ("\tPercentage of spaces " +  percForm.format(100 * (this.numSpaces / this.totalLength)) + "%");
		
		System.out.println(intro);
		System.out.println(byteData);
		System.out.println(numWords);
		System.out.println(spacePct);
	}

}
