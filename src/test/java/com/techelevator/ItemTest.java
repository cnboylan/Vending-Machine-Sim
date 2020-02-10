package com.techelevator;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.Assert;
import com.techelevator.item.*;

public class ItemTest {
	
	Item testCandy = new Candy("A1", "Shockers", new BigDecimal(1));
	Item testChip = new Chip("B1", "Pringles", new BigDecimal(1));
	Item testDrink = new Drink("C1", "Soylent", new BigDecimal(1));
	Item testGum = new Gum("D1", "Orbit", new BigDecimal(1));
	
	@Test
	public void test_get_slot_location() {
		Assert.assertEquals("A1", testCandy.getSlotLocation());
		Assert.assertEquals("B1", testChip.getSlotLocation());
		Assert.assertEquals("C1", testDrink.getSlotLocation());
		Assert.assertEquals("D1", testGum.getSlotLocation());
	}
	
	@Test
	public void test_get_product_name() {
		Assert.assertEquals("Shockers", testCandy.getProductName());
		Assert.assertEquals("Pringles", testChip.getProductName());
		Assert.assertEquals("Soylent", testDrink.getProductName());
		Assert.assertEquals("Orbit", testGum.getProductName());
	}
	
	@Test
	public void test_get_price() {
		Assert.assertEquals(new BigDecimal(1), testCandy.getPrice());
		Assert.assertEquals(new BigDecimal(1), testChip.getPrice());
		Assert.assertEquals(new BigDecimal(1), testDrink.getPrice());
		Assert.assertEquals(new BigDecimal(1), testGum.getPrice());
	}
	
	@Test
	public void test_get_type() {
		Assert.assertEquals("Candy", testCandy.getType());
		Assert.assertEquals("Chip", testChip.getType());
		Assert.assertEquals("Drink", testDrink.getType());
		Assert.assertEquals("Gum", testGum.getType());
	}

}
