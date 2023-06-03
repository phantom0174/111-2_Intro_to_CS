// Assignment 14
// Name: 蕭登鴻
// Student Number: 111502552
// Course 2023_CE1002_B


package A14_111502552;

import java.util.Scanner;


public class A14_111502552 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculator calc = new Calculator();
		
		String exp;
		while (true) {
			System.out.println("Enter a calculation (or enter \"quit\" to exit): ");
			exp = scan.nextLine();
			if (exp.equals("quit")) break;
			
			try {
				double result = calc.calculate(exp);
				System.out.printf("Result: %.1f\n", result);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Program terminated.");
		
		scan.close();
	}
}
