package com.techelevator.item;

import java.math.BigDecimal;

public class Gum extends Item{

	public Gum(String location, String name, BigDecimal price) {
		slotLocation = location;
		productName = name;
		this.price = price;
		type = "Gum";
	}

}
