package calendario_ifsc.exceptions;

public class CampoVazioException extends Exception {

	private String message = "Campo Vazio";

	@Override
	public String getMessage() {
		return this.message;
	}

}
