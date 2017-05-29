package exceptions;

public class ErrorOnlyNumbers extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_ONLY_NUMBERS = "La cédula o NIT debe ser un número";

	public ErrorOnlyNumbers() {
		super(ERROR_ONLY_NUMBERS);
	}
}
