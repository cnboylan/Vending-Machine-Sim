package com.techelevator.item;

import java.math.BigDecimal;

public class Drink extends Item {

	public Drink(String location, String name, BigDecimal price) {
		slotLocation = location;
		productName = name;
		this.price = price;
		type = "Drinks";
	}

}
