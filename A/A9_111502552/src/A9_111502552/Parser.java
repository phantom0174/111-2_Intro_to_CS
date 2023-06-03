package A9_111502552;

import java.util.ArrayList;

public class Parser {
	public ArrayList<Token> tokens = new ArrayList<>();
	
	// identifier, num, special_symbol
	public int[] TYPES_COUNT = { 0, 0, 0 };
	
	public char[] SPECIAL_SYMBOLS = {
	    '+', '-', '*', '/', '>', '<', '=', '%', '&', '|',
	    '^', '\"', '\'', '.', ',', '(', ')', '[', ']', '{',
	    '}', '!', ':', ';'
	};
	
	public String[] SPECIAL_DOUBLE_SYMBOLS = {
		"++", "--", "+=", "<=", ">=", "==", "!=", "&&", "||"
	};
	
	public boolean is_number(char c) {
	    // given a character, return true if it is a number
	    // using ascii code to determine whether c is a number

	    if ((int)c < 48 || (int)c > 57) return false;
	    return true;
	}
	
	public boolean is_special_symbol(char c) {
	    // given a character, return true if it is a special symbol or not

	    for (char symbol : SPECIAL_SYMBOLS) {
	        if (c == symbol) return true;
	    }
	    return false;
	}
	
	public boolean is_double_special_symbol(String s) {
	    for (String double_symbol : SPECIAL_DOUBLE_SYMBOLS) {
	        if (s.equals(double_symbol)) return true;
	    }
	    return false;
	}
	
	public boolean is_alphabet(char c) {
	    // using ascii code to determine whether c is an alphabet
	    if ((int)c < 65 || ((int)c > 90 && (int)c < 97) || (int)c > 122) return false;
	    return true;
	}
	
	public boolean is_unknown_token(char c) {
	    // none of the above
	    return !(is_number(c) || is_special_symbol(c) || is_alphabet(c));
	}
	
	public void parse(String line) {
		while (line.length() > 0) {
	        int breakpoint = -1;
	        String token_type = "";
	        
	        if (is_alphabet(line.charAt(0)) || line.charAt(0) == '_') {  // pattern of identifier
	        	token_type = "Identifier";
	        	for (int i = 0; i < line.length(); i++) {
	                if (line.charAt(i) != '_' && (is_special_symbol(line.charAt(i)) || is_unknown_token(line.charAt(i)))) {
	                    breakpoint = i;
	                    break;
	                }
	            }
	            TYPES_COUNT[0]++;
	        } else if (is_special_symbol(line.charAt(0))) {  // pattern of special-symbol
	        	token_type = "Special Symbol";
	        	if (line.length() > 1 && is_double_special_symbol(line.substring(0, 2))) {
	                breakpoint = 2;
	            } else {
	                breakpoint = 1;
	            }
	            TYPES_COUNT[2]++;
	        } else if (is_number(line.charAt(0))) {  // pattern of number
	        	token_type = "Number";
	        	for (int i = 0; i < line.length(); i++) {
	                if (!is_number(line.charAt(i))) {
	                    breakpoint = i;
	                    break;
	                }
	            }
	            TYPES_COUNT[1]++;
	        } else if (is_unknown_token(line.charAt(0))) {  // pattern of unknown-token
	        	token_type = "Unknown";
	        	breakpoint = 1;
	        }

	        if (breakpoint == -1) breakpoint = line.length();
	        
	        Token token = new Token(line.substring(0, breakpoint), token_type);
	        this.tokens.add(token);
	        line = line.substring(breakpoint);
	    }
	}
}
