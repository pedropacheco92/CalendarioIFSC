package calendario_ifsc.exceptions;

public class UsuarioNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message = "Usuário não encontrado!";

	@Override
	public String getMessage() {
		return this.message;
	}

}
