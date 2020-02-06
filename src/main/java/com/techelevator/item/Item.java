package com.techelevator.item;

import java.math.BigDecimal;

abstract class Item {
	
	protected String slotLocation = "";
	protected String productName = "";
	protected BigDecimal price = new BigDecimal(0.00);
	protected String type = "";

}
