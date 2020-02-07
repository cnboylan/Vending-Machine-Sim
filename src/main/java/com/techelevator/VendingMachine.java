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
	private BigDecimal currentMoney = new BigDecimal(0.00);

	public VendingMachine() {
	
		String path = "vendingmachine.csv";
	private List<String> masterInventoryList = new ArrayList<String>();

	public VendingMachine() {

		String path = "vendingmachine.csv";
		// File inventoryFile = new File(path);
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

				masterInventoryList.add(lineArray[1]);

				if (lineArray[3].equals("Chip")) {

					for (int i = 0; i < 5; i++) {
						Item newChip = new Chip(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newChip);
					}
				}

				if (lineArray[3].equals("Candy")) {
					for (int i = 0; i < 5; i++) {
						Item newCandy = new Candy(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newCandy);
					}
				}

				if (lineArray[3].equals("Drink")) {
					for (int i = 0; i < 5; i++) {
						Item newDrink = new Drink(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newDrink);
					}
				}

				if (lineArray[3].equals("Gum")) {
					for (int i = 0; i < 5; i++) {
						Item newGum = new Gum(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newGum);
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
	public List<Item> getInventoryList() {
		return inventoryList;
	}

	public List<String> getMasterInventoryList() {
		return masterInventoryList;
	}

	public void displayInventory() {
		
		for (String name : getMasterInventoryList()) {
			int count = 0;
			for (Item invName : getInventoryList()) {

				if (name.equals(invName.getProductName())) {
					count++;
				}
			}
			if (count == 0) {
				System.out.println(name + " Sold Out");
			} else

				System.out.println(name + count);
		}
	}

	public void feedMoney() {
		
		Scanner feedScanner = new Scanner(System.in);
		System.out.println("Please insert money (e.g. 1, 2, 5, 10) ");
		String dollarInput = feedScanner.nextLine();
		
		while (!dollarInput.equals("1") || !dollarInput.equals("2") || !dollarInput.equals("5")|| !dollarInput.equals("10")) {
			System.out.println("Invalid dollar amount! Please try again.");
			
			dollarInput = feedScanner.nextLine();
		}
		
		BigDecimal newMoney = new BigDecimal(dollarInput);
		this.currentMoney.add(newMoney);
	}


	public void selectProduct() {

		
	}

	public void finishTransaction() {

	}

}
