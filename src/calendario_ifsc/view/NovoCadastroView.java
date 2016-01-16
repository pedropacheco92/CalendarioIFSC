package calendario_ifsc.view;

import java.util.HashMap;

import calendario_ifsc.presenter.NovoCadastroPresenter;

public interface NovoCadastroView {

	void setPresenter(NovoCadastroPresenter cadastroPresenter);

	void render();

	HashMap getListaCampos();

}
