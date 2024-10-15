package principal;

import java.sql.Connection;

import banco.FabricaConexaoo;
import logiin.ScreenLogin;

public class Main {

	public static void main(String[] args) {

		FabricaConexaoo fab = new FabricaConexaoo();
		Connection con = fab.conectar();

		ScreenLogin Login = new ScreenLogin(con);
		Login.setLocationRelativeTo(null);
		Login.setVisible(true);

	}

}
