package A3_111502552;

import java.util.ArrayList;

public class store {
	private ArrayList<goods> goodList = new ArrayList<>();
	private int money = 0;
	
	public void addItem(goods good) {
		this.goodList.add(good);
	}
	
	public void sell(String id, int sell_amount) {
		for (goods g: this.goodList) {
			if (!g.id.equals(id)) continue;
			
			this.money += sell_amount * g.getPrice();
			g.amount -= sell_amount;
			if (g.amount == 0) this.goodList.remove(g);
			break;
		}
	}
	
	public void showAll() {
		for (goods g: this.goodList) {
			System.out.printf(
				"%s %s %d %d\n",
				g.id, g.getName(), g.getPrice(), g.amount
			);
		}
	}
	
	public void showIncome() {
		System.out.println(this.money);
	}
}
