package calendario_ifsc.form;

import java.awt.Component;
import java.util.HashMap;

import calendario_ifsc.constants.NovoCadastroConstants;

public class NovoCadastroFormValidator extends FormValidator {

	public NovoCadastroFormValidator(HashMap<NovoCadastroConstants, Component> listaform) {
		super(listaform);
	}

	@Override
	public void validateForm() {
		for (Object key : this.listaForm.keySet()) {

		}
	}

}
