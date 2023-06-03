package A14_111502552;

public class Calculator {
	public static String[] ops = { "+", "-", "*", "/" };
	
	public static boolean isValidOp(String s) {
		boolean isValidOp = false;
		for (String op : ops) {
			if (op.equals(s)) {
				isValidOp = true;
				break;
			}
		}
		return isValidOp;
	}
	
	public double calculate(String express) throws Exception {
		if (express.charAt(express.length() - 1) == ' ')
			throw new Exception("Invalid calculation! Please enter again.");
		
		String[] tokens = express.split(" ");

		if (tokens.length != 3)
			throw new Exception("Invalid calculation! Please enter again.");
		
		for (String s: tokens) {
			if (s.equals(""))
				throw new Exception("Invalid calculation! Please enter again.");
		}

		double a, b;
		try {
			a = Double.parseDouble(tokens[0]);
			b = Double.parseDouble(tokens[2]);
		} catch (Exception e) {
			throw new Exception("Invalid number! Please enter a valid number.");
		}
		
		if (!isValidOp(tokens[1]))
			throw new Exception("Invalid operator!");

		if (tokens[1].equals("+")) {
			return a + b;
		} else if (tokens[1].equals("-")) {
			return a - b;
		} else if (tokens[1].equals("*")) {
			return a * b;
		} else if (tokens[1].equals("/")) {
			if (b == 0) throw new Exception("Divisor cannot be zero!");
			return a / b;
		}
		return 0;
	}
}
