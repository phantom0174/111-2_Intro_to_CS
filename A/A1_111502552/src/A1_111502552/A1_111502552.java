/*
Assignment 1
Name: 蕭登鴻
Student Number: 111502552
Course 2023_CE1002_B
*/

package A1_111502552;

import java.util.Scanner;

public class A1_111502552 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double height = scanner.nextDouble();
		double weight = scanner.nextDouble();
		scanner.close();
		
		double bmi = weight / Math.pow(height / 100, 2);
		output(bmi);
	}

	public static void output(double bmi) {
		if (bmi < 18.5) {
			return;
		}

		double[] criteria = { 18.5, 24, 27, 30, 35 };
		String[] msg = { "正常", "過重", "輕度肥胖", "中度肥胖", "重度肥胖" };

		for (int i = 0; i < 4; i++) {
			if (criteria[i] <= bmi && bmi < criteria[i + 1]) {
				System.out.println(msg[i]);
				return;
			}
		}
		System.out.println(msg[4]);
	}
}
