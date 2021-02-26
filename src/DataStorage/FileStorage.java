package DataStorage;

import java.io.IOException;

/**
 * Defines behavior for classes that will store files.
 * @author mullins-dev
 *
 */
public interface FileStorage {

	/**
	 * Determines how many words are in a given file
	 * @return number of words in the file
	 */
	public void getWords();
	
	/**
	 * Determines what type of file is being read
	 * @return the file type of the input file
	 */
	public void getExtension();
	
	/**
	 * Attempts to read from the file. Throws an Input/Output exception
	 * if the given file cannot be read from (i.e. a .ipynb file)
	 * @throws IOException
	 */
	public void readFile() throws IOException;
	
	
	/**
	 * Representation of what the implementer deems to be summary statistics for a file
	 */
	public void runStatistics();
	
	
	
}
