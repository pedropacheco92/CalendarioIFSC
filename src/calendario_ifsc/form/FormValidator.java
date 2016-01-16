package calendario_ifsc.form;

import java.util.HashMap;

public abstract class FormValidator<T, V> {

	HashMap<T, V> listaForm;

	public FormValidator(HashMap<T, V> listaform) {
		this.listaForm = listaform;
	}

	/**
	 * passa pelo form e valida cada item
	 */
	public void validateForm() {
		for (T k : this.listaForm.keySet()) {
			try {
				this.validateItem(k);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateItem(T k) throws Exception {
		// TODO Auto-generated method stub
	}

}
