package com.techelevator.item;

import java.math.BigDecimal;

public abstract class Item {
	
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
