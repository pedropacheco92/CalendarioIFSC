package calendario_ifsc.novo_evento;

import java.sql.SQLException;
import java.util.Date;

public class NovoEventoPresenterImpl implements NovoEventoPresenter {

	private NovoEventoModel novoEventoModel;
	private NovoEventoView novoEventoView;
	private String cpf;

	public NovoEventoPresenterImpl(NovoEventoModel novoEventoModel, NovoEventoView novoEventoView) {
		this.novoEventoModel = novoEventoModel;
		this.novoEventoView = novoEventoView;
	}

	@Override
	public void salvarEvento(Date inicio, Date fim, String nome, String descricao) {
		try {
			this.novoEventoModel.saveEvento(inicio, fim, nome, descricao, this.cpf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
