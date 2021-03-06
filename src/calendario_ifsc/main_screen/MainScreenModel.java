package calendario_ifsc.main_screen;

import java.sql.SQLException;
import java.util.List;

import calendario_ifsc.utils.Evento;

public interface MainScreenModel {

	List<Evento> loadEventos(String cpf) throws SQLException;

	void deletarEvento(String nome, String dataInicio, String dataFim, String descricao, String cpf)
			throws SQLException;

}
