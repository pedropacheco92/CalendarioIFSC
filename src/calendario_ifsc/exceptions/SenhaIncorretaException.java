package calendario_ifsc.exceptions;

public class SenhaIncorretaException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message = "Senha incorreta!";

	@Override
	public String getMessage() {
		return this.message;
	}
}
