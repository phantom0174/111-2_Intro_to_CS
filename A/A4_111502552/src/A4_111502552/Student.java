package A4_111502552;

public class Student {
	private String name, dept;
	
	public int id;
	
	public Student(String name, int id, String dept) {
		this.name = name;
		this.id = id;
		this.dept = dept;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDept() {
		return this.dept;
	}
}
