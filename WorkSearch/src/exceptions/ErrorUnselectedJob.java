package exceptions;

public class ErrorUnselectedJob extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_UNSELECTED_JOB = "No se ha seleccionado ninguna oferta";

	public ErrorUnselectedJob() {
		super(ERROR_UNSELECTED_JOB);
	}
}
