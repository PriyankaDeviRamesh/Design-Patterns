package studentCoursesBackup.myTree;
import java.util.ArrayList;

/* This class has Node constructor, clone(), update() and notifyAll() */
public class Node implements Cloneable, SubjectI, ObserverI {

	public ArrayList<String> course = new ArrayList<String>();
	public int key;
	// public Node left, right, observer1, observer2;
	public Node left, right;
	public ArrayList<Node> observers = new ArrayList<Node>();
	
	public Node(int bNumber, String courseName) {
		key = bNumber;
		course.add(courseName);
		left = null;
		right = null;
	}
	
	public Node clone() { // clones the original node into a backup nodes
		Node newNode = null;
		try {
			newNode = (Node) super.clone();
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return newNode;
	}
	
	@Override
	public void update(Node update, Node type) {  // updates the changes made in the original node
		update.course=type.course;
	}
	@Override
	public void notifyAll(Node i) {
		//update(i.observer1,i );
		//update(i.observer2,i);
		for(Node tmp : observers) {
			update(tmp, i);
		}
		
	}

	public ArrayList<Node> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Node> observers) {
		this.observers = observers;
	}
}