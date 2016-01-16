package calendario_ifsc.form;

import java.util.HashMap;

public abstract class FormValidator {

	HashMap<?, ?> listaForm;

	public FormValidator(HashMap<?, ?> listaform) {
		this.listaForm = listaform;
	}

	public void validateForm() {
	}

}
