package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.item.Item;

public class Menu {

	private VendingMachine machine = new VendingMachine();

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

	public void purchaseMenu() {

		Scanner userInput = new Scanner(System.in);
		
			System.out.println("(1) Feed Money");
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Transaction");
			System.out.println(">> Current Money Provided: " + machine.getCurrentMoney() + " <<");
			
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