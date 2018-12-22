package coursesRegistration.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import coursesRegistration.scheduler.Course;
import coursesRegistration.scheduler.Student;
import coursesRegistration.util.CourseAssignment;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.util.Results;

/**
 * @author Priyanka Devi Ramesh
 *
 */
public class Driver {
	/* main method creates object for FileProcessor , CourseAssignment and results classes and calls writeToFile() and
	 writeToStdout() methods. Also checks for command line argument Exception */
	
	public static void main(String[] args) {

		FileProcessor fp = new FileProcessor();
		if (args.length != 2  || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 2 arguments.");
			System.exit(0);
		} else {

			fp.readFromFile(args);
		}
		Results r = new Results("registration_results.txt");
		CourseAssignment cs = new CourseAssignment(fp, r);
		cs.run();
		r.writeToFile(r.getResult());
		r.close();
		r.writeToStdout(r.getResult());
	}
}
