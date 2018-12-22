package airportSecurityState.driver;

import java.io.IOException;



import airportSecurityState.util.*;
import airportSecurityState.airportStates.AirportContextI;
import airportSecurityState.airportStates.Context;
 

/**
 * @author Priyanka Devi Ramesh
 *
 **/

/**
 *  This is a driver class. This class is responsible for object creation and to validate the inputs accordingly 
 **/

public class Driver {
	public static void main(String args[]) {
		
		if((args.length != 3 ) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
	    	MyLogger.writeOutput(" The Assignment accepts 3 argument! Please type in 3 arguments for the program to run. ");
			System.exit(0);
		}
		
		int debuglevel = 0;
		String input = "input.txt";
		input = args[0];
		
		String output = "output.txt";
		output = args[1];
		
		if(!(input.equals("input.txt"))) {
			System.out.println("File names wrongly entered.");
			System.exit(0);
		}
		
		try {
			debuglevel = Integer.parseInt(args[2]);
			MyLogger.setDebugValue(debuglevel);
			
			if((debuglevel > 4) || (debuglevel < 0)) {
				MyLogger.writeOutput("Error: The value of debugLevel should be in the range 0-4");
				System.exit(0);
			}

			FileProcessor fp = new FileProcessor(args[0]);
			Results r = new Results(args[1]);
			
			AirportContextI context = new Context(fp, r);
			context.parseFile();
			
			r.writeSumToScreen();
			r.writeToFile();
			r.close();
		}
		catch(IllegalArgumentException e) {
			MyLogger.writeOutput(" Error : " + e);
			System.exit(0);
		}
		finally { 
			
		}
		


	}

}
