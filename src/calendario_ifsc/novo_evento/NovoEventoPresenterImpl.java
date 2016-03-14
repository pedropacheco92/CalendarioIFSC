package calendario_ifsc.novo_evento;

import java.util.Date;

public class NovoEventoPresenterImpl implements NovoEventoPresenter {

	private NovoEventoModel novoEventoModel;
	private NovoEventoView novoEventoView;

	public NovoEventoPresenterImpl(NovoEventoModel novoEventoModel, NovoEventoView novoEventoView) {
		this.novoEventoModel = novoEventoModel;
		this.novoEventoView = novoEventoView;
	}

	@Override
	public void salvarEvento(Date date, String nome, String local, String descricao) {
		if (date == null || nome == null || local == null || descricao == null || nome == "" || local == "" || descricao == "") {
		
		}

	}

}
