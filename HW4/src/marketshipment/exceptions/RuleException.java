package marketshipment.exceptions;

public class RuleException extends Exception {


	public RuleException() {
		super("Execption Code: 0 - There is a violation of a rule.");
	}

	public RuleException(String message) {
		super(message);
	}

}
