package com.training.utils;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtils {

	
	private static String[] getPropsAsArray() throws IOException {
		
		String fileName="resources/DbConnection.properties";
		
		InputStream stream = ConnectionUtils.class.getClassLoader().getResourceAsStream(fileName);
		
		Properties props = new Properties();
		 
		props.load(stream);
		 String url=props.getProperty("database.url");
		 String username=props.getProperty("database.userName");
		 String password=props.getProperty("database.password");
		 
		 return new String[] {url, username, password};
	}
	
	public static Connection getConnectionFromPool() {
		
		Connection connection = null;
		
		try {
			
			HikariConfig config = new HikariConfig();
			
			String[] values = getPropsAsArray();
			config.setJdbcUrl(values[0]);
			config.setUsername(values[1]);
			config.setPassword(values[2]);
			config.addDataSourceProperty("maximumPoolSize", 25);
			DataSource dataSource= new HikariDataSource(config);
			
			connection = dataSource.getConnection();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
