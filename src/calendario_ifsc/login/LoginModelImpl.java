package calendario_ifsc.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.mindrot.BCrypt;

import calendario_ifsc.bd.DataBaseConnection;

public class LoginModelImpl implements LoginModel {

	private static int ROUNDS = 12;

	private Connection conn;
	private DataBaseConnection db;
	private String query;

	public LoginModelImpl() {
		this.db = new DataBaseConnection();
	}

	@Override
	public void loadUsuario(String login, String senha) throws Exception {
		if (login == null || login == "" || senha == null || senha == ""){
			throw new CampoVazioException();
		}
		this.conn = this.db.getConnection();
		Statement st = this.conn.createStatement();
		this.query = "SELECT * FROM usuario WHERE cpf = '" + login + "'";
		// + "AND senha = '" + BCrypt.hashpw(senha, BCrypt.gensalt(ROUNDS))
		System.out.println(this.query);
		ResultSet rs = st.executeQuery(this.query);
		boolean senhaOk = false;
		
		if (!rs.next()) {
			rs.close();
			st.close();
		//	throw new UsuarioNotFoundException();
		} else {
			while (rs.next()) {
				senhaOk = this.checkPassword(senha, rs.getString(4));
			}
		}
		rs.close();
		st.close();

		if (!senhaOk) {
		//	throw new SenhaIncorretaException();
		} 
	}

	private String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(ROUNDS);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return (hashed_password);
	}

	private boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if (null == stored_hash || !stored_hash.startsWith("$2a$")) {
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
		}

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return (password_verified);
	}
}
