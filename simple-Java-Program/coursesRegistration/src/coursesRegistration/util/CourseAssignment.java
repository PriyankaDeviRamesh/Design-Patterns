package coursesRegistration.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import coursesRegistration.scheduler.Course;
import coursesRegistration.scheduler.Student;
import coursesRegistration.util.FileProcessor;

public class CourseAssignment {

	Results result;
	FileProcessor fp = new FileProcessor();
   
	/* Creating ArrayList of type Student and Course classes */
	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Student> studentsCourse = new ArrayList<Student>();


	public CourseAssignment(FileProcessor fpIn, Results result) {
		this.fp = fpIn;
		this.result = result;
	}

	public void run() {

		String name = "";
		String string = "";
		int index, index1;
		int classCapacity;
		int classTime;

		/* ArrayList list1 and list2 from FileProcessor*/
		ArrayList<String> list1 = fp.getArrayList1(); 
		ArrayList<String> list2 = fp.getArrayList2();

		
		/* Creating HapMap for storing Student Levels */
		Map<String, Integer> studLevel = new HashMap<String, Integer>();
		studLevel.put("FIRST_YEAR", 1);
		studLevel.put("SECOND_YEAR", 2);
		studLevel.put("THIRD_YEAR", 3);

		/* Parsing courseInfo.txt file into strings */
		
		for (int i = 0; i < list2.size(); i++) {

			if ((string = list2.get(i)) != null) {

				index = string.indexOf("-CAPACITY:");
				name = string.substring(0, index).trim();

				try {
					classCapacity = Integer.parseInt(string.substring(index + 10, string.indexOf(';')).trim());

					index1 = string.indexOf("CLASS_TIMING:");

					classTime = Integer.parseInt(string.substring(index1 + 13).trim());

					Course c1 = new Course(); /* Creating object for Course class */
					c1.setName(name);
					c1.setCapacity(classCapacity);
					c1.setRemaining(classCapacity);
					c1.setTime(classTime);
					courses.add(c1);   /* adding the object into courses ArrayList */
				}

				catch (NumberFormatException e) {
					System.err.println("CAPACITY or CLASS_TIMING should be an Integer");
					e.printStackTrace();
					System.exit(1);
				}

				finally {

				}

			}
		}

		String stud_id = "", year;
		String[] prefer;

     /* Parsing student_coursePrefs.txt into strings */
		
		for (String info : list1) {
			if (info != null) {

				try {
					index = Integer.parseInt(info.substring(0, info.indexOf(' ')).trim());
					stud_id = info.substring(0, info.indexOf(' ')).trim();

					try {

						year = info.substring(info.indexOf("STUDENT_LEVEL:") + 14).trim();

						ArrayList<String> coursePref;
						String preff = info.substring(info.indexOf(' '), info.indexOf(';')).trim();
						prefer = preff.split(", ");
						coursePref = new ArrayList<String>(Arrays.asList(prefer));

						Student s1 = new Student(); /* Creating object for Student class */
						s1.setId(stud_id);
						s1.setYear(year);
						s1.setRequested(coursePref);

						students.add(s1);     /* Adding object into students and studentsCourse ArrayList */
						studentsCourse.add(s1);

					}

					catch (IllegalArgumentException e) {
						System.err.println("Invalid Student_Level");
						e.printStackTrace();
						System.exit(1);
					}

				}

				catch (NumberFormatException e) {
					System.err.println("Student_id should be an integer");
					e.printStackTrace();
					System.exit(1);
				}

			}
		}

		for (int i = 0; i < students.size(); i++) {  /* Sorting students ArrayList based on the StudentLevel  */

			for (int j = students.size() - 1; j > i; j--) {

				if (studLevel.get(students.get(i).getYear()) < studLevel.get(students.get(j).getYear())) {
					Student temp = students.get(i);
					students.set(i, students.get(j));
					students.set(j, temp);
				}

			}
		}

		for (Student std : students) {   /* Assigning courses to students based on their preferences */
			for (String coursePreff : std.getRequested()) {

				if (std.getAssigned().size() < 3) {
					Course course = getCourseByName(coursePreff);
					if (course != null && course.getRemaining() > 0) {
						if (std.getAssigned().isEmpty()) {
							std.setAssigned(coursePreff);
							course.setRemaining(course.getRemaining() - 1);
						} else if (checkClassTimings(std.getAssigned(), coursePreff)) {
							std.setAssigned(coursePreff);
							course.setRemaining(course.getRemaining() - 1);

						}

					} else
						continue;
				} else
					break;
			}
		}

		for (Student s : studentsCourse) {   /* Processing string to the output format */
			ArrayList<String> assigned = s.getAssigned();
			String res="";
			res += s.getId() + ":";
			for(String c: assigned) {
				res += c + ",";
			}
			res = res.substring(0, res.length()-1);
			result.addToResults(res+"\n");
		}
	}

	public static Course getCourseByName(String name) { /* getting courses based on the name */
		for (Course course : courses) {
			if (course.getName().equals(name)) {
				return course;
			}
		}
		return null;
	}

	/* Method to check the class timings and assigned class timings  */
	public static boolean checkClassTimings(ArrayList<String> setCourse, String coursePreference) {

		Course course1 = getCourseByName(coursePreference);
		for (String course : setCourse) {
			Course course2 = getCourseByName(course);
			if (course1.getTime() == course2.getTime()) {
				return false;
			}

		}
		return true;
	}


	@Override
	public String toString() {
		return "CourseAssignment [result=" + result + ", fp=" + fp + "]";
	}

}
