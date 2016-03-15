package calendario_ifsc.novo_evento;

import java.sql.SQLException;
import java.util.Date;

public interface NovoEventoModel {

	void saveEvento(Date inicio, Date fim, String nome, String descricao, String cpf) throws SQLException;

}
