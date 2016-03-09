package calendario_ifsc.main_screen;

import calendario_ifsc.novo_evento.NovoEventoModel;
import calendario_ifsc.novo_evento.NovoEventoModelImpl;
import calendario_ifsc.novo_evento.NovoEventoPresenter;
import calendario_ifsc.novo_evento.NovoEventoPresenterImpl;
import calendario_ifsc.novo_evento.NovoEventoView;
import calendario_ifsc.novo_evento.NovoEventoViewImpl;

public class MainScreenPresenterImpl implements MainScreenPresenter {

	private MainScreenModel cadastroModel;
	private MainScreenView cadastroView;

	public MainScreenPresenterImpl(MainScreenModel cadastroModel, MainScreenView cadastroView) {
		this.cadastroModel = cadastroModel;
		this.cadastroView = cadastroView;
	}

	@Override
	public void createNovoEvento() {
		NovoEventoModel novoEventoModel = new NovoEventoModelImpl();
		NovoEventoView novoEventoView = new NovoEventoViewImpl();
		NovoEventoPresenter novoEventoPresenter = new NovoEventoPresenterImpl(novoEventoModel, novoEventoView);
		novoEventoView.setPresenter(novoEventoPresenter);
		novoEventoView.render();
	}

}
