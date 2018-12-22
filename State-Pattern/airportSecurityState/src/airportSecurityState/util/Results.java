package airportSecurityState.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import airportSecurityState.util.MyLogger.DebugLevel;

/** This is the result class responsible for writing the output in the console
    and in the file based on logger value.
 **/
public class Results implements FileDisplayInterface , StdoutDisplayInterface {

	PrintWriter writer;
	List<String> result = new ArrayList<String>();

	public Results(String name) {
		
		MyLogger.writeMessage ("Results class is invoked", DebugLevel.RESULTS);

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
	} 

	/* Closing printWriter */
	public void close() {
		writer.close();
	}

	@Override /* Writing it in console */
	public void writeSumToScreen() {
		MyLogger.writeMessage("", DebugLevel.NONE);
	}

	@Override
	public void writeToFile() {
		for (String res : result) {
			writer.write(res);
		}
	}

	public void addToResults(String res) {
		this.result.add(res + "\n");
	}

	@Override
	public String toString() {
		return "Results [writer=" + writer + ", result=" + result + "]";
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