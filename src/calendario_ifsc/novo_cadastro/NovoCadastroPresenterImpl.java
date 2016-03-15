package calendario_ifsc.novo_cadastro;

import java.awt.Component;
import java.sql.SQLException;
import java.util.HashMap;

import calendario_ifsc.constants.NovoCadastroConstants;
import calendario_ifsc.form.NovoCadastroFormValidator;
import calendario_ifsc.utils.Usuario;

public class NovoCadastroPresenterImpl implements NovoCadastroPresenter {

	NovoCadastroModel model;
	NovoCadastroView view;
	NovoCadastroFormValidator formValidator;

	HashMap<NovoCadastroConstants, Component> listaCampos;

	public NovoCadastroPresenterImpl(NovoCadastroModel cadastroModel, NovoCadastroView cadastroView) {
		this.model = cadastroModel;
		this.view = cadastroView;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void cadastrar(Usuario usuario) {
		this.listaCampos = this.view.getListaCampos();
		// this.formValidator = new NovoCadastroFormValidator(this.listaCampos);
		// this.formValidator.validateForm();

		try {
			this.model.salvarUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
