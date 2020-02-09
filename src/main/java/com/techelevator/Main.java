package com.techelevator;

public class Main {

	public static void main(String[] args) {
		
		VendingMachine newVM = new VendingMachine();
		Menu newMenu = new Menu(newVM);
		newMenu.mainMenu();

	}

}
