package airportSecurityState.util;

public class MyLogger{

	/** 
	 * This logger is for debugging purpose.
	 * **/
	
 // FIXME: Add more enum values as needed for the assignment
 public static enum DebugLevel { CONSTRUCTOR, STATES, CONTEXT, RESULTS, NONE };

 private static DebugLevel debugLevel;


 // FIXME: Add switch cases for all the levels
 public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	
	case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	case 3: debugLevel = DebugLevel.STATES; break;
	case 2: debugLevel = DebugLevel.CONTEXT; break;
	case 1: debugLevel = DebugLevel.RESULTS; break;
	case 0: debugLevel = DebugLevel.NONE; break;
	
	}
 }

 public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
 }

 public static void writeMessage (String     message  ,
                                  DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
 }

 public static void writeOutput(String message){
		
		System.out.println(message);
		
	}
 
 public String toString() {
	return "The debug level has been set to the following " + debugLevel;
 }
 
 
}