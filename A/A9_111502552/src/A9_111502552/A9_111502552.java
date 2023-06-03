// Assignment 9
// Name: 蕭登鴻
// Student Number: 111502552
// Course 2023_CE1002_B

package A9_111502552;

import java.util.Scanner;

public class A9_111502552 {
	public static void main(String[] args) {
		Parser core_parser = new Parser();
		Scanner scan = new Scanner(System.in);
		
		// input
		String line;
		while (scan.hasNext()) {
			line = scan.next();
			if (line.equals("END_OF_FILE")) break;
			
			core_parser.parse(line);
		}
		
		// process cmds
		String cmd;
		while (true) {
			cmd = scan.next();
			if (cmd.equals("0")) break;
			
			if (cmd.equals("1")) {
				System.out.println("Total number of tokens: " + core_parser.tokens.size());
			} else if (cmd.equals("2")) {
				for (Token t: core_parser.tokens) {
					System.out.println("[" + t.getToken() + "]");
				}
			} else if (cmd.equals("3")) {
				System.out.printf(
					"Identifier: %d, Number: %d, Special Symbol: %d\n",
					core_parser.TYPES_COUNT[0],
					core_parser.TYPES_COUNT[1],
					core_parser.TYPES_COUNT[2]
				);
			} else {
				System.out.println("Invalid command.");
			}
		}
		
		scan.close();
	}
}
