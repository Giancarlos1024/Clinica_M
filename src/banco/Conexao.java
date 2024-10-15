package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String url = "jdbc:mysql://localhost:3306/clinica_medica"; // Cambia por tu URL y base de datos
	private String usuario = "root"; // Cambia por tu usuario MySQL
	private String senha = "123456"; // Cambia por tu contraseña MySQL

	public Connection conectar() {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Registra el controlador de MySQL
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("CONEXÃO FEITA COM SUCESSO!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("FALHA AO SE CONECTAR COM O BANCO DE DADOS");
			e.printStackTrace(); // Muestra el error para diagnóstico
		}
		return conexao;
	}
}
