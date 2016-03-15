package calendario_ifsc.novo_evento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import calendario_ifsc.bd.DataBaseConnection;

public class NovoEventoModelImpl implements NovoEventoModel {

	private Connection conn;
	private DataBaseConnection db;
	private String query;

	public NovoEventoModelImpl() {
		this.db = new DataBaseConnection();
	}

	@Override
	public void saveEvento(Date inicio, Date fim, String nome, String descricao, String cpf) throws SQLException {
		this.conn = this.db.getConnection();
		Statement st = this.conn.createStatement();
		this.query = "SELECT COUNT(*) FROM calendario";
		System.out.println(this.query);
		ResultSet rs = st.executeQuery(this.query);
		rs.next();
		int count = rs.getInt(1) + 1;

		this.query = "INSERT INTO calendario " + "VALUES (" + count + ", " + cpf + ", " + this.geraValue(nome) + 1
				+ ", " + this.geraValue(this.geraValueDate(inicio)) + this.geraValue(this.geraValueDate(fim))
				+ this.geraValueFinal(descricao) + ");";
		System.out.println(this.query);
		st.executeUpdate(this.query);
		st.close();
	}

	private String geraValue(String s) {
		return "'" + s + "', ";
	}

	private String geraValueFinal(String s) {
		return "'" + s + "'";
	}

	private String geraValueDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

}
