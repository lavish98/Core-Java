package com.training.models;

import com.training.models.Products;

public class Electronics extends Products {

	private double wattage;
	private String size;
	private int warranty;
	
	
	public Electronics() {
		super();
	}

	public Electronics(int pCode, String pName, int unitPrice, int quantity, double wattage, String size,
			int warranty) {
		super(pCode, pName, unitPrice, quantity);
		this.wattage = wattage;
		this.size = size;
		this.warranty = warranty;
	}
	
	
	public Electronics(int pCode, String pName, int unitPrice, int quantity) {
		super(pCode, pName, unitPrice, quantity);
	}

	public double getWattage() {
		return wattage;
	}

	public void setWattage(double wattage) {
		this.wattage = wattage;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	

}
