package studentCoursesBackup.driver;

import java.io.FileNotFoundException;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;


/**
 * @author Priyanka Devi Ramesh
 *
 */

/* This main method has object creations for FileProcessor, TreeBuilder and calling its corresponding methods. 
 * It also calls methods to Write in a file and console  */

public class Driver {
	public static void main(String[] args) { 
		
	FileProcessor fobj1 = new FileProcessor();
	FileProcessor fobj2 = new FileProcessor();
	
	TreeBuilder treeobj1 = new TreeBuilder();
	TreeBuilder treeobj2 = new TreeBuilder();
	TreeBuilder treeobj3 = new TreeBuilder();

	Results r = new Results();
	if (args.length != 5  || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}")) {
		System.err.println("Error: Incorrect number of arguments. Program accepts 5 arguments ");
		System.exit(0);
	} else {
 
	  String string, input, delete, output1, output2, output3;
	  
	  input   = args[0];
	  delete  = args[1];
	  output1 = args[2];
	  output2 = args[3];
	  output3 = args[4];
	 
	  // Iterating the input file and inserting into the tree
	  try {
		  while((string = fobj1.readFromFile(input)) != null) {
		  Node[] node1 = new Node[2];
		  // Inserting into the tree
		  try {
		  node1 = treeobj1.insert(string);
		  } catch(ArrayIndexOutOfBoundsException e) {
				System.err.println("BNumber doesnt have a course");
		  }
		  try {
		  if(node1[0]!= null) {
			  treeobj2.insertBackup(node1[0]);
			  treeobj3.insertBackup(node1[1]);
		    }
		  }
		  catch (NullPointerException e) {
			}
	   }
	  } catch (NumberFormatException | FileNotFoundException e ) {
			// TODO Auto-generated catch block
		    System.out.println("Invalid File Format or File not found Exception");
			System.exit(0);
	  }
	  
	  System.out.println("Tree after Insertions");
		r.writeToStdout(treeobj1);
	 try {
	 // Iterating the delete file and deleting the courses from the tree
	 while((string = fobj2.readFromFile(delete)) != null) {
		 treeobj1.delete(string);
	   }
	 } catch (FileNotFoundException | NullPointerException e) {
		 System.out.println("File not found exception or File is empty");
			System.exit(0);
	 }
	   // Writing the output in a console
	    System.out.println("Tree1 after deletions");
		r.writeToStdout(treeobj1);

		System.out.println("Tree2 after deletions");

		r.writeToStdout(treeobj2);

		System.out.println("Tree3 after deletions");

		r.writeToStdout(treeobj3);

		// writing the output in a file
		r.writeToFile(output1, treeobj1);
		r.close();
		r.writeToFile(output2, treeobj2);
		r.close();
		r.writeToFile(output3, treeobj3);
	    r.close();
    }	
  }
}
