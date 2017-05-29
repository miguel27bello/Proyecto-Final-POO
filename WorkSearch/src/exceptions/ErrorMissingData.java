package exceptions;

public class ErrorMissingData extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_MISSING_DATA = "Todos los campos son obligatorios";

	public ErrorMissingData() {
		super(ERROR_MISSING_DATA);
	}
}
