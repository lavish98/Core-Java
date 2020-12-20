package com.training.models;

import com.training.models.Products;

public class Garments extends Products {

	private String size;
	private String material;
	
	public Garments() {
		super();
	}

	public Garments(int pCode, String pName, int unitPrice, int quantity, String size, String material) {
		super(pCode, pName, unitPrice, quantity);
		this.size = size;
		this.material = material;
	}
	

	public Garments(int pCode, String pName, int unitPrice, int quantity) {
		super(pCode, pName, unitPrice, quantity);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
