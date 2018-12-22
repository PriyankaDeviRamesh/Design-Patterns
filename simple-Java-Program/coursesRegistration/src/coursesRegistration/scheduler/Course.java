package coursesRegistration.scheduler;


/* This class has the implementation of course and its informations  */

public class Course{
	String name;
	int capacity;
	int time;
	int remaining;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getRemaining() {
		return remaining;
	}
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", capacity=" + capacity + ", time=" + time + ", remaining=" + remaining + "]";
	}
}
