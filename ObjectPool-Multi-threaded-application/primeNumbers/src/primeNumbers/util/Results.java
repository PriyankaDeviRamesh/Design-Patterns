package primeNumbers.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import primeNumbers.Mylogger.MyLogger;
import primeNumbers.Mylogger.MyLogger.DebugLevel;

/** 
 * This class is responsible for writing the result to the console and computing the sum of prime numbers 
 * and closing the input file. 
 * **/

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    
	PrintWriter writer;
	List<Integer> result= new ArrayList<Integer>();

	@Override
	public String toString() {
		return "Results [writer=" + writer + ", result=" + result + "]";
	}

	public Results(String name) {
 
		MyLogger.writeMessage ("Results Constructor", DebugLevel.CONSTRUCTOR );
		try {
			writer = new PrintWriter(name, "UTF-8");
		
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.err.println(" Invalid File ");
			e.printStackTrace();
		}
	
	}
	
	
	public Results() {
	
		MyLogger.writeMessage ("Results Constructor", DebugLevel.CONSTRUCTOR );
		// TODO Auto-generated constructor stub
	} 

	/* Closing printWriter */
	public void close() {
		writer.close();
	}

	@Override /* Writing it in console */
	public void writeSumToScreen() {
		MyLogger.writeMessage ("Contents of the Results : " + result.toString(), DebugLevel.RESULTS_OBJ );
		Integer sum = 0;
		for (Integer i : this.result) {
			sum = sum + i;
		}
		
		MyLogger.writeMessage("The sum of all the prime numbers is: " + sum, DebugLevel.NONE);
	}

	@Override
	public void writeToFile(String writes) {
		writer.write(writes);
	}
	
	public void addToResults(Integer res) {
		this.result.add(res);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		return result;
	}	
	
}



