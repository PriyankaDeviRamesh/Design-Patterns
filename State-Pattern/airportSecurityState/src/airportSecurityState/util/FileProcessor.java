package airportSecurityState.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import airportSecurityState.util.MyLogger.DebugLevel;

/** 
 * 
 * @author priyankadevi
 * This class is responsible for reading the input file line by line
 * 
 */

/** https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java **/

public class FileProcessor {
	
	int i = 1;
    String readline = "";
	Scanner input;
	String fileName = "";
	
	public FileProcessor(String fNameIn) {
		MyLogger.writeMessage ("FileProcessor Constructor", DebugLevel.CONSTRUCTOR );
		fileName = fNameIn;
	}
	
	public String getFileName() {
		return fileName;
	}
	public String readFromFile(String input_file) {
		
		String file = input_file;
		
		if(i == 1) {
			File files = new File(file);
			
			if(!(files.isFile() && files.exists() && files.canRead())) {
				MyLogger.writeOutput("Invalid Input file ");
			}
			
			try {
				input = new Scanner(files);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			i++;
		}
			try {
				if(input.hasNext()){
					String readline;
					readline = input.nextLine();
					return readline;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public String toString() {
		return "FileProcessor [i=" + i + ", readline=" + readline + ", input=" + input + ", fileName=" + fileName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + i;
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result + ((readline == null) ? 0 : readline.hashCode());
		return result;
	}	
	
	
}
