package com.training.models;

public abstract class Products {

	private int pCode;
	private String pName;
	private int unitPrice;
	private int quantity;
	
	public Products() {
		super();
	}

	public Products(int pCode, String pName, int unitPrice, int quantity) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

	@Override
	public String toString() {
		
		return  "      " + pName + "        " + unitPrice + "        " + quantity + "        " + unitPrice*quantity;
	}

	
}
