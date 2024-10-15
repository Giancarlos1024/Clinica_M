package banco;

import java.sql.Connection;

public class FabricaConexaoo {

	private static Conexao banco = new Conexao();

	public Connection conectar() {

		Connection con = banco.conectar();
		return con;

	}

}
