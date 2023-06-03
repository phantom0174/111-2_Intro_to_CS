package A8_111502552;

import java.util.ArrayList;

public class User {
	private String name;
	private ArrayList<Sheet> sheets = new ArrayList<>();
	
	User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addSheet(Sheet sheet) {
		this.sheets.add(sheet);
	}
	
	public Sheet getSheet(String sheet_name) {
		for (Sheet s: this.sheets) {
			if (!s.getName().equals(sheet_name)) continue;
			
			return s;
		}
		return null;
	}
}
