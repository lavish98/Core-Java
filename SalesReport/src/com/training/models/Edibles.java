package com.training.models;

import java.time.LocalDate;

import com.training.models.Products;

public class Edibles extends Products {

	
	private String mfg;
	private String exp;
	private String foodType;
	
	public Edibles() {
		super();
	}
	
	
	public Edibles(int pCode, String pName, int unitPrice, int quantity, String mfg, String exp,
			String foodType) {
		super(pCode, pName, unitPrice, quantity);
		this.mfg = mfg;
		this.exp = exp;
		this.foodType = foodType;
	}
	
	
	public Edibles(int pCode, String pName, int unitPrice, int quantity) {
		super(pCode, pName, unitPrice, quantity);
	}


	public String getMfg() {
		return mfg;
	}


	public void setMfg(String mfg) {
		this.mfg = mfg;
	}


	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

}
