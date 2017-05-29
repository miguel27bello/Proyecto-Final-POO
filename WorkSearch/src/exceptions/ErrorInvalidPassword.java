package exceptions;

public class ErrorInvalidPassword extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_INVALID_PASSWORD = "Contraseña Invalida";

	public ErrorInvalidPassword() {
		super(ERROR_INVALID_PASSWORD);
	}
}
