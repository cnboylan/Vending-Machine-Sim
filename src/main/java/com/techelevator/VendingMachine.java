package com.techelevator;

import java.io.File;
import com.techelevator.item.*;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.item.Chip;
import com.techelevator.item.Drink;

public class VendingMachine {

	private List<Item> inventoryList = new ArrayList<Item>();
	private List<Item> masterInventoryList = new ArrayList<Item>();
	private BigDecimal currentMoney = new BigDecimal(0.00);
	private Scanner myScanner = new Scanner(System.in);

	public VendingMachine() {

		String path = "vendingmachine.csv";
		File inventoryFile = new File(path);

		if (!inventoryFile.exists()) { // Checks if the file is there
			System.out.println(path + " doesn't exist");
			System.exit(1); // Ends the program

		} else if (!inventoryFile.isFile()) {
			System.out.println(path + " isn't a file");
			System.exit(1); // Ends program if the file's not there
		}
			
		try (Scanner fileScanner = new Scanner(inventoryFile)) {

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] lineArray = line.split("\\|");

				if (lineArray[3].equals("Chip")) {

					for (int i = 0; i < 5; i++) {
						Item newChip = new Chip(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newChip);
						
						if (i == 0) {
							masterInventoryList.add(newChip);
						}
					}
				}

				if (lineArray[3].equals("Candy")) {
					for (int i = 0; i < 5; i++) {
						Item newCandy = new Candy(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newCandy);
					
						if (i == 0) {
							masterInventoryList.add(newCandy);
						}
					}
				}

				if (lineArray[3].equals("Drink")) {
					for (int i = 0; i < 5; i++) {
						Item newDrink = new Drink(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newDrink);
						
						if (i == 0) {
							masterInventoryList.add(newDrink);
						}
					}
				}

				if (lineArray[3].equals("Gum")) {
					for (int i = 0; i < 5; i++) {
						Item newGum = new Gum(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newGum);
						
						if (i == 0) {
							masterInventoryList.add(newGum);
						}
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

// Prints out the inventory list from the vending machine	
//	public void printOut() {
//		for (Item item : inventoryList) {
//			System.out.println(item.getSlotLocation() + " " + item.getProductName() + " " + item.getPrice() + " " + item.getType());
//		}
//	}
	public void setCurrentMoney(BigDecimal currentMoney) {
		this.currentMoney = currentMoney;
	}
	
	public BigDecimal getCurrentMoney() {
		return this.currentMoney;
	}
	
	public List<Item> getInventoryList() {
		return inventoryList;
	}

	public List<Item> getMasterInventoryList() {
		return masterInventoryList;
	}

	public void displayInventory() {
		
		for (Item item : getMasterInventoryList()) {
			int count = 0;
			for (Item invName : getInventoryList()) {

				if (item.getProductName().equals(invName.getProductName())) {
					count++;
				}
			}
			if (count == 0) {
				System.out.println(item.getProductName() + " Sold Out");
			} else

				System.out.println(item.getProductName() + " " + count);
		}
	}

	public void feedMoney() {
		
		System.out.println("Please insert money (e.g. 1, 2, 5, 10) ");
		String dollarInput = myScanner.nextLine();
		
		if (!dollarInput.equals("1") && !dollarInput.equals("2") && !dollarInput.equals("5") && !dollarInput.equals("10")) {
			System.out.println("Invalid dollar amount! Please try again.");
			feedMoney();
		} else {
			setCurrentMoney(currentMoney.add(new BigDecimal(dollarInput)));
		}
	}


	public void selectProduct() {
		
		for (Item item : getMasterInventoryList()) {
			System.out.println(item.getSlotLocation() + " " + item.getProductName() + " " + item.getPrice());
		}
		
		System.out.println("Enter the item code: ");
		String itemCode = myScanner.nextLine();
		
		if() {
			
		}
		
		if() {
			
		}
			
	}

	public void finishTransaction() {

	}

}
