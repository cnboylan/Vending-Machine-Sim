package com.techelevator;

import java.util.Scanner;

public class MainMenu {
	
	public MainMenu(VendingMachine machine) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
		
		String userIn = userInput.nextLine();

		if (userIn.equals("1")) {
			//List All Items and their Quantities in Vending Machine
			machine.displayInventory();
		}

		if (userIn.equals("2")) {
			//Direct to Purchase Menu
			PurchaseMenu newPurchase = new PurchaseMenu();
			newPurchase.purchaseMenu(machine);
		}

		if (userIn.equals("3")) {
			//Exit Application
			System.exit(0);
		}
	}
}

/*// Clock.java
public class Clock {
    private int hour;
    private int minute;
    private int second;

    // Constructor has same name and spelling of class.
    // Notice there isn't a return type with constructors.    
    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;*/






//example of using a scanner to iterate through a file. 
/*int wordCount = 0;
	while(scan.hasNext()) {
		scan.next();
	   
		wordCount ++;
	}
	
	System.out.println("Word Count: "+wordCount);
	scan.close();*/