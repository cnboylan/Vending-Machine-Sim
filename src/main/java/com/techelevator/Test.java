package com.techelevator;

public class Test {

	public static void main(String[] args) {
		
		VendingMachine test = new VendingMachine();
		/*for(String name : test.getMasterInventoryList()) {
			System.out.println(name);
		}*/
		Menu testMenu = new Menu(test);
		testMenu.mainMenu();
		//test.printOut();

	}

}
