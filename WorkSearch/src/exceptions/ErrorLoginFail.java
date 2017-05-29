package exceptions;

public class ErrorLoginFail extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_NO_LOGIN = "Usuario no existe";

	public ErrorLoginFail() {
		super(ERROR_NO_LOGIN);
	}
}
