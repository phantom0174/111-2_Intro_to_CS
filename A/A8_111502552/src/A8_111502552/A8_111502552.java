// Assignment 8
// Name: 蕭登鴻
// Student Number: 111502552
// Course 2023_CE1002_B

package A8_111502552;

import java.util.Scanner;

public class A8_111502552 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Excel excel = new Excel();
		
		String cmd;
		while (true) {
			Excel.showMenu();
			cmd = scan.next();
			
			if (cmd.equals("1")) { // create user
				String user_name = scan.next();
				User user = new User(user_name);
				excel.addUser(user);
				
				System.out.printf(
					"Create a user named \"%s\"\n\n",
					user_name
				);
			} else if (cmd.equals("2")) { // create sheet for user
				String target_user = scan.next(),
						sheet_name = scan.next();
				
				Sheet sheet = new Sheet(sheet_name);
				excel.addSheetToUser(target_user, sheet);
				System.out.printf(
					"Create a sheet named \"%s\" for \"%s\".\n\n",
					sheet_name, target_user
				);
			} else if (cmd.equals("3")) { // check sheet value
				String target_user = scan.next(),
						sheet_name = scan.next();
				
				Sheet sheet = excel.fetchSheetFromUser(target_user, sheet_name);
				if (sheet == null) {
					System.out.println("This sheet is not accessible\n");
					continue;
				}
				
				sheet.showContent();
			} else if (cmd.equals("4")) { // modify sheet value
				String target_user = scan.next(),
						sheet_name = scan.next();
				
				Sheet sheet = excel.fetchSheetFromUser(target_user, sheet_name);
				if (sheet == null) {
					System.out.println("This sheet is not accessible\n");
					continue;
				}
				
				sheet.showContent();
				int i = scan.nextInt(), j = scan.nextInt();
				String op = scan.next();
				
				sheet.setValue(i, j, Excel.evaluate(op));
				sheet.showContent();
			} else if (cmd.equals("5")) { // modify sheet auth
				String target_user = scan.next(),
						sheet_name = scan.next();
				
				Sheet sheet = excel.fetchSheetFromUser(target_user, sheet_name);
				if (sheet == null) continue;
				
				sheet.toggleAuth();
				
				System.out.printf(
					"\n%s %s %s\n\n",
					target_user, sheet_name, sheet.getAuth()
				);
			} else if (cmd.equals("6")) { // share sheet
				String target_user = scan.next(),
						sheet_name = scan.next(),
						shared_user = scan.next();
				
				Sheet sheet = excel.fetchSheetFromUser(target_user, sheet_name);
				if (sheet == null) {
					System.out.println("This sheet is not accessible\n");
					continue;
				}
				
				excel.getUser(shared_user).addSheet(sheet);
				
				System.out.printf(
					"Share \"%s\"'s \"%s\" with \"%s\"\n\n",
					target_user, sheet_name, shared_user
				);
			} else if (cmd.equals("7")) { // exit
				break;
			}
		}
		
		scan.close();
	}
}
