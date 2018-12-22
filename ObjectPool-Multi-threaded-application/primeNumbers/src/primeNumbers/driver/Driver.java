package primeNumbers.driver;

import primeNumbers.util.FileProcessor;
import primeNumbers.util.IsPrime;
import primeNumbers.util.Results;

import primeNumbers.Mylogger.MyLogger;
import primeNumbers.myList.CreateWorkers;

/**
 * @author Priyanka Devi Ramesh
 *
 */ 

/**
 * This is a driver class with main(). This is responsible for creating objects for all the classes and then to validate the information accordingly   **/
public class Driver {
	public static void main(String args[]) {
		if(args.length != 3 ) {
			MyLogger.writeOutput("Error: Incorrect number of arguments. Program accepts 3 arguments or Check the input names");
			System.exit(0);
		} 

		int NUM_THREADS = 0;
		int debuglevel = 0;

		try {
			debuglevel = Integer.parseInt(args[2]);
			MyLogger.setDebugValue(debuglevel);
		}
		catch(NumberFormatException e) {
			MyLogger.writeOutput("Error: debuglevel should be Integer");
			System.exit(0);
		}
		finally {

		}

		if((debuglevel > 4) || (debuglevel < 0)) {
			MyLogger.writeOutput("Error: The value of debugLevel should be in the range 0-4");
			System.exit(0);
		}

		try {
			NUM_THREADS = Integer.parseInt(args[1]);
		} catch(NumberFormatException e) {
			MyLogger.writeOutput("Error: NUM_THREADS should be Integer");
			System.exit(0);
		} finally {

		}

		if((NUM_THREADS > 5) || (NUM_THREADS < 1)) {
			MyLogger.writeOutput("Error: The value of NUM_THREADS should be in the range 1-5");
			System.exit(0);
		}

		FileProcessor fp = new FileProcessor(args[0]);
		Results r = new Results();
		IsPrime ip = new IsPrime();

		CreateWorkers cw = new CreateWorkers(fp, r, ip);
		cw.startWorkers(args[1]);

		r.writeSumToScreen();
	}
}