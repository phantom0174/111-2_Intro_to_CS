package A4_111502552;

import java.util.List;
import java.util.ArrayList;

public class Department {
	private List<Student> students = new ArrayList<>();
	private String name;
	
	public Department(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addStudent(Student s) {
		this.students.add(s);
	}
	
	public List<Student> getStudents() {
		return this.students;
	}
	
	public int getTotalStudentsInDep() {
		return this.students.size();
	}
	
	public void showDepStudents() {
		for (Student s: this.students) {
			System.out.println(s.getName());
		}
	}
}
