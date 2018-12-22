package studentCoursesBackup.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
/* This class is responsible for reading the input file line by line*/ 

public class FileProcessor {

	int i = 1;
    String readline = "";
	Scanner input;
	public String readFromFile(String input_file) throws FileNotFoundException {	
		String file = input_file;
		if(i == 1) {
			File files = new File(file);
			input = new Scanner(files);
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
}
