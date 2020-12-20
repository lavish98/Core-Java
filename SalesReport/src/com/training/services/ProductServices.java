package com.training.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.training.models.Edibles;
import com.training.models.Electronics;
import com.training.models.Garments;
import com.training.models.Products;



public class ProductServices {

	private Connection connection;
	
	
	public ProductServices() {
		super();
	}

	public ProductServices(Connection connection) {
		super();
		this.connection = connection;
	}
	
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
	
	public boolean add(Products t) {
		
		int rowAdded=0;
		String sql="";
		if(t instanceof Edibles) {
			sql ="insert into Edibles values(?,?,?,?,?)";
		} 
		else if(t instanceof Garments) {
			sql ="insert into Garments values(?,?,?,?,?)";
		}
		else {
			sql ="insert into Electronics values(?,?,?,?,?)";
		}
		
		try(PreparedStatement pstmt= connection.prepareStatement(sql)) {
			
			pstmt.setDate(1, getCurrentDate());
			pstmt.setString(2, t.getpName());
			pstmt.setInt(3, t.getUnitPrice());
			pstmt.setInt(4,t.getQuantity());
			pstmt.setInt(5,t.getpCode());
			
			rowAdded = pstmt.executeUpdate(); 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rowAdded==1?true:false;
	}
	
	public List<Products> findAll(String category, String date) {
		
		String sql = "select * from " + category +" where sellingDate = '"+ date +"'";
		
		List<Products> list = new ArrayList<>();
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql);){
					
			ResultSet tableSet= pstmt.executeQuery();
			
			while(tableSet.next()) {
				
				Products newProduct = rowMapper(tableSet, category);
				list.add(newProduct);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	private Products rowMapper(ResultSet tableSet, String category) throws SQLException {
		
		int qty = tableSet.getInt("quantity");
		String pName = tableSet.getString("productName");
		int unitPrice  = tableSet.getInt("unitPrice");
		int pCode  = tableSet.getInt("productCode");
		
		Products newProduct;
		
		if(category.equals("Edibles")){
			newProduct = new Edibles(pCode, pName, unitPrice, qty);
		}
		else if(category.equals("Electronics")){
			newProduct = new Electronics(pCode, pName, unitPrice, qty);
		}
		else {
			newProduct = new Garments(pCode, pName, unitPrice, qty);
		}
		return newProduct;
	}
	
	public List<Products> findMax(String category) {
		
		String sql = "select * from " + category +" ORDER BY quantity DESC limit 3";
		
		List<Products> list = new ArrayList<>();
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql);){
						
			ResultSet tableSet= pstmt.executeQuery();
			
			while(tableSet.next()) {
				
				Products newProduct = rowMapper(tableSet, category);
				list.add(newProduct);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
