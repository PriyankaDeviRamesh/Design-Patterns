package genericCheckpointing.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//This result class to write the results in the console and on the file.

public class Results implements FileDisplayInterface, StdOutDisplayInterface {

	private List<String> results;

	public Results() {
		results = new ArrayList<String>();
	}

	/**
	 * @param s adds line 's' to the list of results
	 */
	public void addToResults(String s) {
		this.results.add(s);
	}

	/**
	 * Prints all the lines currently stored in results
	 */
	public void printResult() {
		for (String s : results) {
			System.out.println(s);
		}
	}

	/**
	 * @return fileName specifies the pathname of the file which will be written to
	 */
	public void writeToFile(String fileName) {
		Path file = Paths.get(fileName);
		try {
			Files.write(file, results, Charset.forName("UTF-8"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * @return List<String> returns the list of student details stored
	 */
	public List<String> getResults() {
		return results;
	}

	/**
	 * @param results sets the list of student details to be stored
	 */
	public void setResults(List<String> results) {
		this.results = results;
	}

	/**
	 * returns String returns empty string
	 */
	public String toString() {
		return results.toString();
	}
}
