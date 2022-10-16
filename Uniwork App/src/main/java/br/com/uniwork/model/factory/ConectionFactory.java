package br.com.uniwork.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
	private Connection conn = null;
	
	public Connection getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm93000", "290802");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Erro de conexão com o banco...");
			e.printStackTrace();
		}
		return null;
		
	}
	
}
