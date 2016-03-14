package calendario_ifsc.novo_evento;

import java.util.Date;

public interface NovoEventoPresenter {

	void salvarEvento(Date date, String nome, String local, String descricao);

}
