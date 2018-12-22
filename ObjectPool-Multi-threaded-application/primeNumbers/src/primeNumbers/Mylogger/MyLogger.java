package primeNumbers.Mylogger;

public class MyLogger{

	/** 
	 * This logger is for debugging purpose.
	 * **/
	
 // FIXME: Add more enum values as needed for the assignment
 public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR, RUN, RESULTS_ENTRY, RESULTS_OBJ, NONE
                                };

 private static DebugLevel debugLevel;


 // FIXME: Add switch cases for all the levels
 public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	
	case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	case 3: debugLevel = DebugLevel.RUN; break;
	case 2: debugLevel = DebugLevel.RESULTS_ENTRY; break;
	case 1: debugLevel = DebugLevel.RESULTS_OBJ; break;
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