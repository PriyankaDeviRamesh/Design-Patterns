package coursesRegistration.scheduler;

import java.util.ArrayList;

/* This class has the implementation of student and its informations  */

public class Student {
	String id;
	String year;
	ArrayList<String> assigned;
	ArrayList<String> requested;
	
	public Student() {
		this.assigned = new ArrayList<String>();
		this.requested = new ArrayList<String>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ArrayList<String> getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned.add(assigned);
	}

	public ArrayList<String> getRequested() {
		return requested;
	}

	public void setRequested(ArrayList<String> requested) {
		this.requested = requested;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", year=" + year + ", assigned=" + assigned + ", requested=" + requested + "]";
	}
	
	
}
