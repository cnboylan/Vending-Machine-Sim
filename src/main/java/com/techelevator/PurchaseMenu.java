package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseMenu {
	
	BigDecimal currentMoney = new BigDecimal(0.00);
	Scanner userInput = new Scanner(System.in);
	
	public void displayMenu(String mainMenuChoice) {
		
		System.out.println(">(1) Feed Money");
		System.out.println(">(2) Select Product");
		System.out.println(">(3) Finish Transaction");
		System.out.println("> > Current Money Provided: " + currentMoney + " >");
		
		String userChoice = userInput.nextLine();
		
		if(userChoice.equals("1")) {
			
		}
		
	}
	
//	public void feedMoney() {
//		
//	}

}
