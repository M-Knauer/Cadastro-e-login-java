package myConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private final static String url = "jdbc:sqlserver://localhost:52484;databaseName=CadastroLogin;integratedSecurity=true;";
	private static Connection conexao = null;
	
	private Conexao() {
		
	}
	
	private static void tentarConexao() throws ClassNotFoundException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		try {
			conexao = DriverManager.getConnection(url);
			System.out.println("Conectado com sucesso!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Conexao falhou!");
		}
		
	}
	
	public static Connection getConexao() throws ClassNotFoundException {
		
		if (conexao == null) {
			tentarConexao();		
		}
		return conexao;
	}
}
