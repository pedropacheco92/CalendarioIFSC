package calendario_ifsc.novo_evento;

import java.util.Date;

public interface NovoEventoPresenter {

	void salvarEvento(Date inicio, Date fim, String nome, String descricao);

	void setCpf(String cpf);

}
