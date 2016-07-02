package com.victoria.Entity;

import java.util.ArrayList;

public class Passenger {

	private String id,name,alias,balance;
	
	public Passenger(ArrayList<String> res) {
		// TODO Auto-generated constructor stub
		id=res.get(0);
		alias=res.get(1);
		name=res.get(2);
		balance=res.get(3);
	}
	
	public String getAlias() {
		return alias;
	}
	public String getBalance() {
		return balance;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}

