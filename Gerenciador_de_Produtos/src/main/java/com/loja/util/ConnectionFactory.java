package com.loja.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:1433/banco", "root", "1234");
		} catch (Exception e) {
			throw new RuntimeException("Erro ao banco: " + e);
		}
		
		
	}
}
