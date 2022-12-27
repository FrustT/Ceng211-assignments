package marketshipment.exceptions;

public class ExistingSerialNumberException extends RuleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExistingSerialNumberException() {
		super("Exception Code: 1 - Existing Serial Number!");
	}
	
	public ExistingSerialNumberException(String message) {
		super(message);
	}
}
