// Assignment 4
// Name: 蕭登鴻
// Student Number: 111502552
// Course 2023_CE1002_B


package A4_111502552;

import java.util.Scanner;

public class A4_111502552 {
	public static void main(String[] args) {
		Department csie = new Department("CSIE"),
			ee = new Department("EE"),
			math = new Department("MATH");
		
		Institute eecs = new Institute("EECS"),
			sci = new Institute("SCI");
		
		eecs.addDepartment(csie);
		eecs.addDepartment(ee);
		sci.addDepartment(math);
		
		Scanner scan = new Scanner(System.in);
		int cmd = 0;
		while (true) {
			System.out.println("1.add student 2.show the number of students in a department 3.show all the students in a department 4.show the number of students in an institute 5.exit:");
			
			cmd = scan.nextInt();
			
			if (cmd == 1) {
				System.out.println("Please input the student info name/id/department:");
				
				Student s = new Student(scan.next(), scan.nextInt(), scan.next());
				
				Department d = eecs.fetchDepartment(s.getDept());
				if (d == null) d = sci.fetchDepartment(s.getDept());
				
				d.addStudent(s);
			} else if (cmd == 2) {
				System.out.println("Please input the department:");
				
				String dept = scan.next();
				Department d = eecs.fetchDepartment(dept);
				if (d == null) d = sci.fetchDepartment(dept);
				
				System.out.println(d.getTotalStudentsInDep());
			} else if (cmd == 3) {
				System.out.println("Please input the department:");
				
				String dept = scan.next();
				Department d = eecs.fetchDepartment(dept);
				if (d == null) d = sci.fetchDepartment(dept);
				
				d.showDepStudents();
			} else if (cmd == 4) {
				System.out.println("Please input the institute:");
				
				String inst = scan.next();
				if (inst.equals("EECS")) {
					System.out.println(eecs.getTotalStudentsInInstitute());
				} else {
					System.out.println(sci.getTotalStudentsInInstitute());
				}
			} else break;
		}
		scan.close();
	}
}
