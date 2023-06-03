package A8_111502552;

import java.util.ArrayList;

public class Excel {
	private ArrayList<User> users = new ArrayList<>();
	
	public static void showMenu() {
		System.out.println(
				"----------Menu----------\n"
				+ "1. Create a user\n"
				+ "2. Create a sheet\n"
				+ "3. Check a sheet\n"
				+ "4. Change a value in a sheet\n"
				+ "5. Change a sheet's access right\n"
				+ "6. Collaborate with an other user\n"
				+ "7. Exit\n"
				+ "-------------------------"
		);
	}
	
	public static double evaluate(String op) {
		if (op.contains("+")) {
			String[] ops = op.split("\\+");
			return Double.parseDouble(ops[0]) + Double.parseDouble(ops[1]);
		} else if (op.contains("-")) {
			String[] ops = op.split("-");
			return Double.parseDouble(ops[0]) - Double.parseDouble(ops[1]);
		} else if (op.contains("*")) {
			String[] ops = op.split("\\*");
			return Double.parseDouble(ops[0]) * Double.parseDouble(ops[1]);
		} else if (op.contains("/")) {
			String[] ops = op.split("/");
			return Double.parseDouble(ops[0]) / Double.parseDouble(ops[1]);
		}
		return Double.parseDouble(op);
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public User getUser(String user_name) {
		for (User u: this.users) {
			if (!u.getName().equals(user_name)) continue;
			
			return u;
		}
		return null;
	}
	
	public void addSheetToUser(String user_name, Sheet sheet) {
		User user = this.getUser(user_name);
		if (user != null) user.addSheet(sheet);
	}
	
	public Sheet fetchSheetFromUser(String user_name, String sheet_name) {
		User user = this.getUser(user_name);
		if (user == null) return null;
		
		return user.getSheet(sheet_name);
	}
}
