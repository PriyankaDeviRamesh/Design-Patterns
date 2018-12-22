package coursesRegistration.util;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor {

	private Scanner input2;
	private Scanner input1;
	private ArrayList<String> list1;
	private ArrayList<String> list2;

	public void readFromFile(String[] args) {
		/* Reading a file line by line and storing it into an ArrayList 
		  https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
		 */
		
		try {
			if ((args[0] != null) && (args[1] != null)) {   /* checking for null exception */
				File file1 = new File(args[0]);
				File file2 = new File(args[1]);
				input1 = new Scanner(file1);
				list1 = new ArrayList<String>();

				input2 = new Scanner(file2);
				list2 = new ArrayList<String>();

				while (input1.hasNextLine()) {
					list1.add(input1.nextLine());
				}
			

				while (input2.hasNextLine()) {
					list2.add(input2.nextLine());
				}				
			}
			input1.close(); /* Closing input1 and input2 */
			input2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "FileProcessor [input2=" + input2 + ", input1=" + input1 + ", list1=" + list1 + ", list2=" + list2 + "]";
	}

	public ArrayList<String> getArrayList1() {
		return list1;
	}

	public ArrayList<String> getArrayList2() {
		return list2;
	}

}
