package A8_111502552;


public class Sheet {
	private String name;
	private double[][] value = new double[5][5];
	private String auth = "Editable";
	
	Sheet(String name) {
		this.name = name;
		this.iniContent();
	}
	
	private void iniContent() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.value[i][j] = 0;
			}
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAuth() {
		return this.auth;
	}
	
	public void toggleAuth() {
		if (this.auth.equals("ReadOnly")) {
			this.auth = "Editable";
		} else {
			this.auth = "ReadOnly";
		}
	}
	
	public void setValue(int i, int j, double new_value) {
		if (this.auth.equals("ReadOnly")) {
			System.out.println("This sheet is not accessible");
			return;
		}
		
		this.value[i][j] = new_value;
	}
	
	public void showContent() {
		System.out.print("\n");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				double v = this.value[i][j];
				if (v == (int)v) {
					System.out.printf("%d", (int)v);
				} else {
					System.out.printf("%.1f", v);					
				}
				
				if (j < 4) System.out.print(", ");
				else System.out.print(",\n");
			}
		}
		System.out.print("\n");
	}
}
