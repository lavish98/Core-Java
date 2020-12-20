package com.training.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.training.models.Edibles;
import com.training.models.Products;
import com.training.services.ProductServices;
import com.training.utils.ConnectionUtils;

class testProductServices {

	ProductServices service = new ProductServices();
	Connection con = ConnectionUtils.getConnectionFromPool();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Program Execution Starting...");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Task finished");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Class Execution starting...");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Class execution finished");
	}

	@Test
	@DisplayName("test for row gets added or not")
	void testIfRowIsAdded() {
		Edibles e1 = new Edibles(100,"testItem",10,1,"11-11-11", "12-12-12","type");
		ProductServices service = new ProductServices(con);
		boolean actual = service.add(e1);
		assertEquals(true,actual);
	}
	
	@Test
	@DisplayName("test to check that retrieving data is not empty")
	void testListNotEmpty() {
		String tableName = "Edibles";
		String dateValidation = "2020-11-12";
		List<Products> list=service.findAll(tableName,dateValidation);
				assertNotNull(list);
	}
	@Test
	@DisplayName("test to check maximum sale info is not empty")
	void testMaxSaleisNotEmpty() {
		String tableName = "Garments";
		List<Products> list1=service.findMax(tableName);
				assertNotNull(list1);						
	}

}
