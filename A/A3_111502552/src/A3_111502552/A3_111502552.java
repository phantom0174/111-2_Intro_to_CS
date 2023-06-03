// Assignment 3
// Name: 蕭登鴻
// Student Number: 111502552
// Course 2023_CE1002_B


package A3_111502552;

import java.util.Scanner;

public class A3_111502552 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		store main_store = new store();

		int cmd = 0;
		while (cmd != 5) {
			System.out.println("1.add goods 2.sell 3.show all item in store 4.show income 5.exit:");
			cmd = scan.nextInt();

			if (cmd == 1) {
				System.out.println("please input goods info id/name/price/amount:");
				
				String id = scan.next(), name = scan.next();
				int price = scan.nextInt(), amount = scan.nextInt();
				
				goods good = new goods(id, name, price, amount);
				main_store.addItem(good);
			} else if (cmd == 2) {
				System.out.println("please input goods id and the sell amount:");
				
				String id = scan.next();
				int amount = scan.nextInt();
				
				main_store.sell(id, amount);
			} else if (cmd == 3) {
				main_store.showAll();
			} else if (cmd == 4) {
				main_store.showIncome();
			}
		}
		
		scan.close();
	}
}
