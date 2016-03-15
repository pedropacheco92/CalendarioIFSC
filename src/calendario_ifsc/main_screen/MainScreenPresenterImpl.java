package calendario_ifsc.main_screen;

import java.sql.SQLException;
import java.util.List;

import calendario_ifsc.novo_evento.NovoEventoModel;
import calendario_ifsc.novo_evento.NovoEventoModelImpl;
import calendario_ifsc.novo_evento.NovoEventoPresenter;
import calendario_ifsc.novo_evento.NovoEventoPresenterImpl;
import calendario_ifsc.novo_evento.NovoEventoView;
import calendario_ifsc.novo_evento.NovoEventoViewImpl;
import calendario_ifsc.utils.Evento;

public class MainScreenPresenterImpl implements MainScreenPresenter {

	private MainScreenModel cadastroModel;
	private MainScreenView cadastroView;

	private String cpf;

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
		novoEventoPresenter.setCpf(this.cpf);
		novoEventoView.render();
	}

	@Override
	public List<Evento> loadEventos() {
		try {
			return this.cadastroModel.loadEventos(this.cpf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public void deletar(int deletar) {
		try {
			this.cadastroModel.deletarEvento(deletar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
