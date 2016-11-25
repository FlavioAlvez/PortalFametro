package br.edu.fametro.portal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnector {
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Fametro","postgres","Syscon94");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro de Conexão" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Erro de Driver" + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return con;
	}
}
