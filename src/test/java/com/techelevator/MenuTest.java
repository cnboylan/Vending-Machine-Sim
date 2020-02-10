package com.techelevator;


import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.Test;
import org.junit.Assert;
import com.techelevator.item.*;

public class MenuTest {
	
	VendingMachine testVM = new VendingMachine();
	Menu testMenu = new Menu(testVM);
	Scanner testScanner = new Scanner(System.in);
	
	@Test
	public void checking_main_menu_directs_user_correctly() {
		System.out.println("Please enter the menu choice to test for: ");
		String test = testScanner.nextLine();
		
		testMenu.mainMenu();
		Assert.assertEquals(mainMenu(), );
	}

}
