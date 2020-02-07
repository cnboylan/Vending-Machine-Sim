package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

	VendingMachine machine = new VendingMachine();
	BigDecimal currentMoney = new BigDecimal(0.00);

	public Menu(VendingMachine machine) {

		this.machine = machine;
	}

	public void mainMenu() {

		Scanner userInput = new Scanner(System.in);

		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");

		String userIn = userInput.nextLine();

		if (userIn.equals("1")) {
			// List All Items and their Quantities in Vending Machine
			machine.displayInventory();
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

	public void purchaseMenu() {

		Scanner userInput = new Scanner(System.in);
		
			System.out.println("(1) Feed Money");
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Transaction");
			System.out.println(">> Current Money Provided: " + currentMoney + " <<");
			
			String userChoice = userInput.nextLine();

			if (userChoice.equals("1")) {
				System.out.println("Please enter your dollar amount (e.g. 1, 2, 5, 10) ");
				String dollarInput = userInput.nextLine();

				machine.feedMoney(dollarInput);
			}

			if (userChoice.equals("2")) {
				machine.selectProduct();
			}

			if (userChoice.equals("3")) {
				machine.finishTransaction();
			}
			
			else
				purchaseMenu();

	}

}

/*
 * // Clock.java public class Clock { private int hour; private int minute;
 * private int second;
 * 
 * // Constructor has same name and spelling of class. // Notice there isn't a
 * return type with constructors. public Clock(int hour, int minute, int second)
 * { this.hour = hour; this.minute = minute; this.second = second;
 */

//example of using a scanner to iterate through a file. 
/*
 * int wordCount = 0; while(scan.hasNext()) { scan.next();
 * 
 * wordCount ++; }
 * 
 * System.out.println("Word Count: "+wordCount); scan.close();
 */