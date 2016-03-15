package calendario_ifsc.main_screen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import calendario_ifsc.bd.DataBaseConnection;
import calendario_ifsc.utils.Evento;

public class MainScreenModelImpl implements MainScreenModel {

	private Connection conn;
	private DataBaseConnection db;
	private String query;

	public MainScreenModelImpl() {
		this.db = new DataBaseConnection();
	}

	@Override
	public List<Evento> loadEventos(String cpf) throws SQLException {
		if (cpf == null || cpf == "") {
			return null;
		}
		List<Evento> eventos = new ArrayList<Evento>();

		this.conn = this.db.getConnection();
		Statement st = this.conn.createStatement();
		this.query = "SELECT * FROM calendario WHERE cpf = '" + cpf + "'";
		System.out.println(this.query);
		ResultSet rs = st.executeQuery(this.query);

		while (rs.next()) {
			eventos.add(new Evento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),
					rs.getDate(6), rs.getString(7)));
		}

		rs.close();
		st.close();

		return eventos;
	}

	@Override
	public void deletarEvento(String nome, String dataInicio, String dataFim, String descricao, String cpf)
			throws SQLException {
		this.conn = this.db.getConnection();
		Statement st = this.conn.createStatement();
		this.query = "DELETE FROM calendario WHERE cpf = '" + cpf + "' AND nome = '" + nome + "' AND descricao = '"
				+ descricao + "';";
		System.out.println(this.query);
		st.executeUpdate(this.query);
	}
}
