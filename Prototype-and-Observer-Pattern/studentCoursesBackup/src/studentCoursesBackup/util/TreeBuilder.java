package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

/*
   Reference : http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 */ 

/* This class has logic for Inserting and deleting in a tree and also printing the nodes of the tree */

public class TreeBuilder {


	@Override
	public String toString() {
		return "TreeBuilder [root=" + root + ", str=" + str + ", printTree()=" + printTree() + "]";
	}


	Node root;
	String str = "";
	
	public TreeBuilder() {
		root = null;
	}
	
	public void search(int node) 
	{
		root = searchCourse(root, node);
	}
	public Node searchCourse(Node root, int node) 
	{    
		if (root == null || root.key == node)  // if node is at root		
		{
			return root;
		} 
		if (root.key > node)  // if node is at left half of the tree
		{
			return searchCourse(root.left, node);			
		} 
		else  // if node is at right half of the tree
		{
			return searchCourse(root.right, node);			
		}
	}
	public Node[] insert(String line) {  // Inserting into the original tree
		String[] str = line.split(":");
		int bNum = Integer.parseInt(str[0]);
		
		String course = str[1];
		if(bNum > 999 || bNum < 000) {
			System.err.println(bNum+ "invalid b Number");
			return null;
		}
		
		if(str[1].length() == 1) {
			if(course.matches("[A-Z]")) {
				root = insertCourse(root,bNum,course);
				Node[] node1 = new Node[2];
				
				node1[0] = root.clone();  // cloning the original tree node.
				node1[1] = root.clone();                            
				
				root.getObservers().add(node1[0]);  // linking it with the observers.
				root.getObservers().add(node1[1]);
				return node1;
			} else {
				System.err.println(course + "Invalid course");
				return null;
			}
		}
		else {
			System.err.println("adding multiple courses for b-Number"+bNum);
		}
		return null;
	}
	
	
	public Node insertCourse(Node root, int bNum, String course) {  // recursive calls to insert the courses into the tree
		if(root == null) {
			root = new Node(bNum, course);
			return root;
		}
		
		if(bNum < root.key) {
			root.left = insertCourse(root.left, bNum, course);
		} else if(bNum >root.key) {
			root.right = insertCourse(root.right, bNum, course);			
		} else if (bNum == root.key) {
			if(!root.course.contains(course)) {
				root.course.add(course);
			}
		}
		return root;
					
		
	}
	
	public void insertBackup(Node node1) {  // inserting the cloned nodes
		root = insertCourseBackup(root, node1);
	
		/*root.observer1 = null;  // making the observers null for the backup nodes
		root.observer2 = null;*/

	}

	
	public Node insertCourseBackup(Node root, Node node1) {  // recursive calls for inserting into the backup nodes
		
		if (root == null) {
			root = node1;
			return root;
		}

		if (node1.key < root.key)
			root.left = insertCourseBackup(root.left, node1);
		else if (node1.key > root.key)
			root.right = insertCourseBackup(root.right, node1);
		else if (node1.key == root.key) {
			root = node1;
		}

		return root;
	}
	
	public void delete(String line) { // deleting the nodes in the tree

		String[] str =line.split(":");
		int bNum = Integer.parseInt(str[0]);

		String deleteCourse = str[1];

		root = deleteCourse(root, bNum, deleteCourse);
		root.notifyAll(root);   // notifying all the observers
	}

	
	public Node deleteCourse(Node root, int bNum, String course) {  // recursive calls to delete the nodes of the tree.
		if (root == null) {
			return root;
		}
		if (bNum < root.key) {
			root.left = deleteCourse(root.left, bNum, course);
		} else if (bNum > root.key) {
			root.right = deleteCourse(root.right, bNum, course);
		} else if (bNum == root.key) {
			if (root.course.contains(course)) {
				root.course.remove(course);
			}
		}
		return root;
	}
	
	public String printTree() {  // for printing the nodes of the tree
		str = "";
		printTree(root);
		return str;
	}

	
	public void printTree(Node root) { // inorder traversal for sorted nodes
		if (root != null) {
			printTree(root.left);
			str = str + root.key + ":" + root.course + "\n";
			printTree(root.right);
		}
	}

	
}
