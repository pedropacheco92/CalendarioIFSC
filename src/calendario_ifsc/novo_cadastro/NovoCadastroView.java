package calendario_ifsc.novo_cadastro;

import java.util.HashMap;

public interface NovoCadastroView {

	void setPresenter(NovoCadastroPresenter cadastroPresenter);

	void render();

	HashMap getListaCampos();

}
