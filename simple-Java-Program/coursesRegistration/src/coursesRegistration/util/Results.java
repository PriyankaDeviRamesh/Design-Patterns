package coursesRegistration.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/* To Write the output to the file
  https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
  */

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	PrintWriter writer;
	List<Integer> result= new ArrayList<Integer>();

	@Override
	public String toString() {
		return "Results [writer=" + writer + ", result=" + result + "]";
	}

	public Results(String name) {s
		
		try {
			writer = new PrintWriter(name, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.err.println(" Invalid File ");
			e.printStackTrace();
		}
	}
	
	/* Closing printWriter */
	public void close() {
		writer.close();
	}

	@Override /* Writing it in console */
	public void writeSumToScreen(String writes) {
		Integer sum = 0;
		for (Integer i : this.result) {
			sum = sum + i;
		}
		
		System.out.println("The sum of all the prime numbers is: " + sum);
	}

	@Override
	public void writeToFile(String writes) {
		writer.write(writes);
	}
	
	public void addToResults(String res) {
		this.result += res;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}



