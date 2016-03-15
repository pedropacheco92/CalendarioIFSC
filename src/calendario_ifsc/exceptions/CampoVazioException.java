package calendario_ifsc.exceptions;

public class CampoVazioException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message = "Campo Vazio";

	@Override
	public String getMessage() {
		return this.message;
	}

}
