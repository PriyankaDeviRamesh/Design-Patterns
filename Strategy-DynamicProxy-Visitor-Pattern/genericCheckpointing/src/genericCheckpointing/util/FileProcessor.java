package genericCheckpointing.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//File Processor class for reading the file content and parsing it.

public class FileProcessor {


	private String path;
	private File file;
	private Scanner scanner;
	public boolean flag = false;

	public FileProcessor(String p) {
		path = p;
		file = new File(path);
		if(!(file.isFile() && file.exists()) && file.canRead()) {
			try {
			file.createNewFile();
		} catch (IOException e) {
			}
		}
		try {
			scanner = new Scanner(file);
			scanner.useDelimiter(System.getProperty("line.separator"));
		} catch (FileNotFoundException e) {
			System.out.println(path +" not found");
		}
	}

	/**
	 * @return String the path of the file
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path set the path of the file
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return boolean true if next token is the end of file
	 */
	public boolean isEOF() {
		if (scanner.hasNext())
			return false;
		else {
			scanner.close();
			flag = true;
			return true;
		}
	}

	/**
	 * @return String the line that's currently read
	 */
	public String readLine() {
		return scanner.next();
	}

	/**
	 * @return String returns empty string
	 */
	public String toString() {
		return "";
	}

	/**
	 * @return File the file object for the specified path
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file set the File to be read
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return Scanner returns the Scanner object
	 */
	public Scanner getScanner() {
		return scanner;
	}

	/**
	 * @param scanner sets the Scanner object
	 */
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}
