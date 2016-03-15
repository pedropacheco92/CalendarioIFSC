package calendario_ifsc.main_screen;

import java.util.List;

import calendario_ifsc.utils.Evento;

public interface MainScreenPresenter {

	void createNovoEvento();

	List<Evento> loadEventos();

	void setCpf(String cpf);

	void deletar(String nome, String dataInicio, String dataFim, String descricao);
}
