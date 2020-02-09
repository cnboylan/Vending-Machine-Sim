package com.techelevator;
import org.junit.Assert;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import com.techelevator.item.*;

public class VendingMachineTest {
	
	VendingMachine testVM = new VendingMachine();
	
	@Test
	public void checking_length_of_master_inventory_list() {
		Assert.assertEquals(16, testVM.getMasterInventoryList().size());
	}
	
	@Test
	public void checking_length_of_current_inventory_list() {
		Assert.assertEquals(80, testVM.getInventoryList().size());
	}
	
}
