package com.techelevator;

import java.io.File;
import com.techelevator.item.*;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
	private DecimalFormat df = new DecimalFormat("#,##0.00");
	private String[] foodSounds = {"Crunch", "Munch", "Glug", "Chew"};

	public VendingMachine() {
		
		//SETS VENDING MACHINE FILE TO "PATH" VARIABLE
		String path = "vendingmachine.csv";
		//STORES "PATH" IN "inventoryFile" VARIABLE
		File inventoryFile = new File(path);
		
		// CHECKS IF FILE EXISTS. ENDS PROGRAM IF NOT.
		if (!inventoryFile.exists()) { 
			System.out.println(path + " doesn't exist");
			System.exit(1); 
		
		//CHECKS IF FILE IS A FILE. ENDS PROGRAM IF NOT.
		} else if (!inventoryFile.isFile()) {
			System.out.println(path + " isn't a file");
			System.exit(1); // Ends program if the file's not there
		}
		
		//CREATES A SCANNER TO READ THROUGH INVENTORY FILE
		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			
		//SEPERATES INVENTORY FILE BY "|" MAKES FILE INTO STRING ARRAYS WE CAN INDEX INTO.
			
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] lineArray = line.split("\\|");

		//CREATES ITEM CHIP, STOCKS THEM TO 5 IN INVENTORYLIST ON STARTUP
		//ADDS THE NAME OF CHIP TO MASTERINVENTORYLIST
				
				if (lineArray[3].equals("Chip")) {
					
					for (int i = 0; i < 5; i++) {
						Item newChip = new Chip(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newChip);
						
						if (i == 0) {
							masterInventoryList.add(newChip);
						}
					}
				}
		
		//CREATES ITEM CANDY, STOCKS THEM TO 5 IN INVENTORYLIST ON STARTUP
		//ADDS THE NAME OF CANDY TO MASTERINVENTORYLIST
				
				if (lineArray[3].equals("Candy")) {
					for (int i = 0; i < 5; i++) {
						Item newCandy = new Candy(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newCandy);
					
						if (i == 0) {
							masterInventoryList.add(newCandy);
						}
					}
				}

		//CREATES ITEM DRINK, STOCKS THEM TO 5 IN INVENTORYLIST ON STARTUP
		//ADDS THE NAME OF DRINK TO MASTERINVENTORYLIST
				if (lineArray[3].equals("Drink")) {
					for (int i = 0; i < 5; i++) {
						Item newDrink = new Drink(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newDrink);
						
						if (i == 0) {
							masterInventoryList.add(newDrink);
						}
					}
				}
		//CREATES ITEM GUM, STOCKS THEM TO 5 IN INVENTORYLIST ON STARTUP
		//ADDS THE NAME OF GUM TO MASTERINVENTORYLIST
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
	
	
	
	//GETTERS AND SETTERS
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

	//DISPLAY INVENTORY METHOD
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
	
	//FEEDMONEY METHOD
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

	//SELECTPRODUCT METHOD
	public void selectProduct() {
		
		for (Item item : getMasterInventoryList()) {
			System.out.println(item.getSlotLocation() + " " + item.getProductName() + " " + item.getPrice());
		}
		
		System.out.println("_____________________\n");
		System.out.println("Enter the item code: ");
		String itemCode = myScanner.nextLine().toUpperCase();
		
		for (Item item : getMasterInventoryList()) {
			
			if(itemCode.equals(item.getSlotLocation())) {
				
				for(Item invItem : getInventoryList()) {
					
					if(itemCode.equals(item.getSlotLocation())) {
						String type = item.getType();
						String productName = item.getProductName();
						BigDecimal price = item.getPrice();
						inventoryList.remove(invItem);
						currentMoney = currentMoney.subtract(price);
						String sound = "";
						
						if (type.equals("Chip")) {
							sound = foodSounds[0];
						} else if (type.equals("Candy")) {
							sound = foodSounds[1];
						} else if (type.equals("Drink")) {
							sound = foodSounds[2];
						} else if (type.equals("Gum")) {
							sound = foodSounds[3];
						}
						
						System.out.println(productName + " $" + df.format(price) + " $"+ df.format(currentMoney));
						System.out.println(sound + " " + sound + ", Yum!\n");
						
						return;
					}
				}
				System.out.println("Item Sold Out. Select A Different Item.\n");
				return;
			}
		}
		System.out.println("Invalid Item Code. Try Again.\n");
	}
			
		
		
		
		
		
		
		
			
	
	
	//FINISHTRANSACTION METHOD
	public void finishTransaction() {

	}

}
