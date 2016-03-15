package calendario_ifsc.novo_cadastro;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.BCrypt;

import calendario_ifsc.bd.DataBaseConnection;
import calendario_ifsc.utils.Usuario;

public class NovoCadastroModelImpl implements NovoCadastroModel {

	private Connection conn;
	private DataBaseConnection db;
	private String query;

	private static int ROUNDS = 12;

	public NovoCadastroModelImpl() {
		this.db = new DataBaseConnection();
	}

	@Override
	public void salvarUsuario(Usuario usuario) throws SQLException {
		this.conn = this.db.getConnection();
		Statement st = this.conn.createStatement();

		String senha = this.hashPassword(usuario.getSenha());

		this.query = "INSERT INTO usuario " + "VALUES (" + this.geraValue(usuario.getCpf()) + 1 + ", "
				+ this.geraValue(usuario.getEmail()) + this.geraValue(senha) + this.geraValueFinal(usuario.getNome())
				+ ");";

		System.out.println(this.query);
		st.executeUpdate(this.query);

		this.query = "INSERT INTO aluno " + "VALUES (" + this.geraValue(usuario.getCpf())
				+ this.geraValueFinal(usuario.getMatricula()) + ");";

		System.out.println(this.query);
		st.executeUpdate(this.query);

		st.close();
	}

	private String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(ROUNDS);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return (hashed_password);
	}

	private String geraValue(String s) {
		return "'" + s + "', ";
	}

	private String geraValueFinal(String s) {
		return "'" + s + "'";
	}

}
