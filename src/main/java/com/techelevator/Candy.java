package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{

	public Candy(String location, String name, BigDecimal price) {
		slotLocation = location;
		productName = name;
		this.price = price;
		type = "Candy";
	}

}
