package com.techelevator;
import org.junit.Assert;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.Assert;
import com.techelevator.item.*;

public class VendingMachineTest {
	
	VendingMachine testVM = new VendingMachine();
	Scanner testScanner = new Scanner(System.in);
	
	@Test
	public void test_set_and_get_currentMoney() {
		testVM.setCurrentMoney(new BigDecimal(5));
		Assert.assertTrue(testVM.getCurrentMoney().compareTo(new BigDecimal(5)) == 0);
	}
	
	@Test
	public void checking_length_of_master_inventory_list() {
		Assert.assertEquals(16, testVM.getMasterInventory().size());
	}
	
	@Test
	public void checking_length_of_current_inventory_list() {
		Assert.assertEquals(80, testVM.getInventoryList().size());
	}
	

	@Test
	public void feed_money_updates_balance() {
		System.out.println("Enter amount of money tested for: ");
		int test = testScanner.nextInt();
		testVM.feedMoney();
		
		Assert.assertEquals(testVM.getCurrentMoney(), new BigDecimal(test));
	}
	
	@Test
	public void finish_transaction_updates_balance() {
		testVM.feedMoney();
		testVM.finishTransaction();
		Assert.assertTrue(testVM.getCurrentMoney().compareTo(new BigDecimal(0)) == 0);
	}
	
	@Test
	public void select_product_updates_inventory_when_item_available() {
		System.out.println("Enter amount of money tested for (#.##): ");
		String test = testScanner.nextLine();
		// PLEASE CHOOSE ITEM B2/B3/C3/C4 FOR THE TEST
		
		testVM.feedMoney();
		testVM.selectProduct();
		
		Assert.assertEquals(testVM.getCurrentMoney(), new BigDecimal(test).subtract(new BigDecimal(1.50)));
		Assert.assertEquals(79, testVM.getInventoryList().size());
	}


}
