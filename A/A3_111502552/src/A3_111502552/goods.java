package A3_111502552;

public class goods {
	public String id;
	public int amount;
	
	private String name;
	private int price;
	
	goods(String id, String name, int price, int amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
}
