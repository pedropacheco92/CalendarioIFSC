package calendario_ifsc.novo_cadastro;

import java.awt.Component;
import java.util.HashMap;

import calendario_ifsc.constants.NovoCadastroConstants;
import calendario_ifsc.form.NovoCadastroFormValidator;

public class NovoCadastroPresenterImpl implements NovoCadastroPresenter {

	NovoCadastroModel model;
	NovoCadastroView view;
	NovoCadastroFormValidator formValidator;

	HashMap<NovoCadastroConstants, Component> listaCampos;

	public NovoCadastroPresenterImpl(NovoCadastroModel cadastroModel, NovoCadastroView cadastroView) {
		this.model = cadastroModel;
		this.view = cadastroView;

	}

	@Override
	public void cadastrar() {
		this.listaCampos = this.view.getListaCampos();
		this.formValidator = new NovoCadastroFormValidator(this.listaCampos);
		this.formValidator.validateForm();
	}

}
