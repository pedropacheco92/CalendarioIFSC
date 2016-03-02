package calendario_ifsc.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {

	private static final String USER = "postgres";
	private static final String PASS = "root";
	private static final String URL = "jdbc:postgresql://localhost/teste";

	private Connection connection;

	public DataBaseConnection() {
		try {
			this.connect();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar no banco: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro desconhecido: " + e.getMessage());
		}
	}

	private void connect() throws SQLException {
		Properties props = new Properties();
		props.setProperty("user", USER);
		props.setProperty("password", PASS);

		this.connection = DriverManager.getConnection(URL, props);
	}

	/**
	 * Classe cria uma conexão com o banco de dados e retorna a conexão
	 *
	 * @return Connection
	 */

	public Connection getConnection() {
		return this.connection;
	}

}
