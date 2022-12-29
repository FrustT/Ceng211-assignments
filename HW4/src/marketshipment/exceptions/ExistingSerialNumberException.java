package marketshipment.exceptions;

public class ExistingSerialNumberException extends RuleException {

	public ExistingSerialNumberException() {
		super("Exception Code: 1 - Existing Serial Number!");
	}
	
	public ExistingSerialNumberException(String message) {
		super(message);
	}
}
