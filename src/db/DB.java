package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	
	private static Connection conn = null; //java.sql.Connection
	
	
	public static Connection getConnection() {
		// vai ter que retornar o objeto conn retornado em cima
		// se nulo escrever um codigo para conectar no banco
		if (conn == null) {
			try {	
				//pegando propriedades
				Properties props = loadProperties();
				// pegando url
				String url = props.getProperty("dburl"); //dburl é a terceira linha do arquivo db.properties onde tem a url de destino do banco
				// conectamos com o banco de dados ( instanciar um objeto do tipo conection ) salvando o objeto na varivel conn 
				conn = DriverManager.getConnection(url, props); 
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	
	
	// Metodo para fechar a conexão 
	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
	}
	
	
	// Metodo para carregar as propriedades definidas no arquivo db.properties
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs); // comando load faz a leitura do arquivo properties apontado pelo InputStream fs e guarda os dados dentro do objeto Properties
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	

	// Metodos auxiliares para fechar ResultSet e Statement
	public static void closeStatement(Statement st ) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		try{
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}








}
