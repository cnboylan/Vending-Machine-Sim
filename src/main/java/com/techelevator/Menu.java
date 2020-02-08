package com.techelevator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Menu {

	private VendingMachine machine = new VendingMachine();
	private DecimalFormat df = new DecimalFormat("#,##0.00");

	public Menu(VendingMachine machine) {

		this.machine = machine;
	}

//MAINMENU METHOD 
	
	public void mainMenu() {

		Scanner userInput = new Scanner(System.in);

		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");

		String userIn = userInput.nextLine();

		if (userIn.equals("1")) {
			// List All Items and their Quantities in Vending Machine
			machine.displayInventory();
			mainMenu();
					
					
		}

		if (userIn.equals("2")) {
			// Direct to Purchase Menu
			purchaseMenu();
		}

		if (userIn.equals("3")) {
			// Exit Application
			System.exit(0);
		}
		
		else
			mainMenu();
	}

//PURCHASEMENU METHOD
	
	public void purchaseMenu() {

		Scanner userInput = new Scanner(System.in);
		
			System.out.println("(1) Feed Money");
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Transaction");
			System.out.println(">> Current Money Provided: $" + df.format(machine.getCurrentMoney()) + " <<");
			
			String userChoice = userInput.nextLine();

			if (userChoice.equals("1")) {
				
				machine.feedMoney();
				purchaseMenu();
			}

			if (userChoice.equals("2")) {
				machine.selectProduct();
				purchaseMenu();
			}

			if (userChoice.equals("3")) {
				machine.finishTransaction();
				mainMenu();
			}
			
			else
				purchaseMenu();

	}

}
