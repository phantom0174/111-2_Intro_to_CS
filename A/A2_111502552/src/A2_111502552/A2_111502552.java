// Assignment 2
// Name: 蕭登鴻
// Student Number: 111502552
// Course 2023_CE1002_B

package A2_111502552;

import java.util.Scanner;

public class A2_111502552 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String tar_str = input.next().toLowerCase();
		input.close();

		System.out.println(isRecur(tar_str));
	}

	public static String isRecur(String s) {
		int head = 0, tail = s.length() - 1;
		boolean coda_used = false;

		while (head < tail) {
			final char h = s.charAt(head), t = s.charAt(tail);
			if (h == t) {
				head++;
				tail--;
			} else {
				if (coda_used)
					break;
				if (s.charAt(head + 1) == t)
					head++;
				else if (h == s.charAt(tail - 1))
					tail--;

				coda_used = true;
			}
		}

		if (s.charAt(head) == s.charAt(tail)) {
			if (coda_used)
				return "Yes if a word is deleted";

			return "Yes";
		}

		return "No";
	}
}
