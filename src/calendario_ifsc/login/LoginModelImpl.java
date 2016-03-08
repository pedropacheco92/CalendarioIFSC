package calendario_ifsc.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import calendario_ifsc.bd.DataBaseConnection;

public class LoginModelImpl implements LoginModel {

	private Connection conn;
	private DataBaseConnection db;

	public LoginModelImpl() {
		this.db = new DataBaseConnection();
	}

	@Override
	public void loadUsuario(String login, String senha) throws Exception {
		this.conn = this.db.getConnection();
		Statement st = this.conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM tb_usuarios WHERE user_name = '" + login + "'");
		while (rs.next()) {
			System.out.print("Column 1 returned ");
			System.out.println(rs.getString(1));
		}
		rs.close();
		st.close();

	}

}
