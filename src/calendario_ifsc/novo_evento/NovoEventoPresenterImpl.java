package calendario_ifsc.novo_evento;

public class NovoEventoPresenterImpl implements NovoEventoPresenter {
	
	private NovoEventoModel novoEventoModel;
	private NovoEventoView novoEventoView;

	public NovoEventoPresenterImpl(NovoEventoModel novoEventoModel, NovoEventoView novoEventoView) {
		this.novoEventoModel = novoEventoModel;
		this.novoEventoView = novoEventoView;
	}

}
