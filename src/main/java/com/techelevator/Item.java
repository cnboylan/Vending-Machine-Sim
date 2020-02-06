package com.techelevator;

import java.math.BigDecimal;

abstract class Item {
	
	protected String slotLocation = "";
	protected String productName = "";
	protected BigDecimal price = new BigDecimal(0.00);
	protected String type = "";
	
	public String getSlotLocation() {
		return slotLocation;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	

}
