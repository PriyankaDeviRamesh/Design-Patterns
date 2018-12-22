package studentCoursesBackup.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/* To Write the output to the file
  https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
  */

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	PrintWriter writer;
	
	/* Closing printWriter */
	public void close() {
		writer.close();
	}

	@Override
	public String toString() {
		return "Results [writer=" + writer + "]";
	}

	@Override /* Writing the results in a console */
	public void writeToStdout(TreeBuilder tree) {
		System.out.println(tree.printTree());
		
	}

	@Override // Writing the results in a file 
	public void writeToFile(String output, TreeBuilder tree) {
		try {
			writer = new PrintWriter(output, "UTF-8");
			writer.write(tree.printTree());
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.err.println(" Invalid File ");
			e.printStackTrace();
		}
		
	}

}
