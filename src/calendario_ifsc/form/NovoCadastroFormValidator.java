package calendario_ifsc.form;

import java.util.HashMap;

import javax.swing.JTextField;

import calendario_ifsc.constants.NovoCadastroConstants;
import calendario_ifsc.exceptions.CampoVazioException;

public class NovoCadastroFormValidator<T> extends FormValidator {

	public NovoCadastroFormValidator(HashMap<NovoCadastroConstants, JTextField> listaform) {
		super(listaform);
	}

	@Override
	public void validateItem(Object k) throws CampoVazioException {
		JTextField aux = (JTextField) super.listaForm.get(k);
		if (aux.getText().equals("")) {
			throw new CampoVazioException();
		}

	}

}
