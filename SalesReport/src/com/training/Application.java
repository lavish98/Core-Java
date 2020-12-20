package com.training;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.models.Edibles;
import com.training.models.Electronics;
import com.training.models.Garments;
import com.training.models.Products;
import com.training.services.ProductServices;
import com.training.utils.ConnectionUtils;

public class Application {

	
	public static void print(List<Products> productList) {
		
		Iterator<Products> itr = productList.iterator();
		int i=1;
		System.out.println("S.No.  Item Name   Unit Price   Quantity   Amount");
		while(itr.hasNext()) {
			
			Products inv=itr.next();
			System.out.print(i);
			System.out.println(inv);
			i++;
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		
		Logger log= Logger.getRootLogger();
		//Edibles product=new Edibles(104,"Red beans",70,47,"2020-10-10","2021-6-10","Non-Veg");
		//Electronics product =new Electronics(204,"Laptop",60000,9,5.6,"15.6inch",3);
		//Garments product =new Garments(304,"Jacket",2500,14,"Medium","gents");
		Connection connection= ConnectionUtils.getConnectionFromPool();
		
		ProductServices service = new ProductServices(connection);
		//service.add(product);
		log.info("finding edibles");
		List<Products> list = service.findAll("Edibles", "2020-11-12");
		print(list);
		log.info("edibles found");
		
		log.info("finding electronics");
		List<Products> list1 = service.findAll("Electronics", "2020-11-12");
		print(list1);
		log.info("electronics found");
		
		log.info("finding garments");
		List<Products> list2 = service.findAll("Garments", "2020-11-12");
		print(list2);
		log.info("garments found");
		
		log.info("finding max quantity sold for edibles");
		List<Products> list3=service.findMax("Edibles");
		print(list3);
		
		log.info("finding max quantity sold for electronics");
		List<Products> list4=service.findMax("Electronics");
		print(list4);
		
		log.info("finding max quantity sold for garments");
		List<Products> list5=service.findMax("Garments");
		print(list5);
	}

}
