package A4_111502552;

import java.util.List;
import java.util.ArrayList;

public class Institute {
	private List<Department> departments = new ArrayList<>();
	private String name;
	
	public Institute(String name) {
		this.name = name;
	}
	
	public void addDepartment(Department d) {
		this.departments.add(d);
	}
	
	public Department fetchDepartment(String dept) {
		for (Department d: this.departments) {
			if (d.getName().equals(dept)) return d;
		}
		return null;
	}

	public int getTotalStudentsInInstitute() {
		int sum = 0;
		for (Department d: this.departments) {
			sum += d.getTotalStudentsInDep();
		}
		return sum;
	}
}
