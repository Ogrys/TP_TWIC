package com.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	@Bean
	public static Connection getConnexionBDD() {
		String url = "jdbc:mysql://localhost:3307/twic?serverTimezone=UTC";
		String user = "root";
		String passwd = "";
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, passwd);

		} catch (Exception e) {
			System.out.println(e);;
		}
		return connection;
	}
}