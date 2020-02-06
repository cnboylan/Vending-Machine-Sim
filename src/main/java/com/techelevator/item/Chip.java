package com.techelevator.item;

import java.math.BigDecimal;

public class Chip extends Item {

	public Chip(String location, String name, BigDecimal price) {
		slotLocation = location;
		productName = name;
		this.price = price;
		type = "Chip";
		
	}

}
