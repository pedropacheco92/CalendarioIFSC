package calendario_ifsc.novo_cadastro;

import java.sql.SQLException;

import calendario_ifsc.utils.Usuario;

public interface NovoCadastroModel {

	void salvarUsuario(Usuario usuario) throws SQLException;

}
