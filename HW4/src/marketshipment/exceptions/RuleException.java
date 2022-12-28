package marketshipment.exceptions;

public class RuleException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RuleException() {
		super("Execption Code: 0 - There is a violation of a rule.");
	}
	
	public RuleException(String message) {
		super(message);
	}

}
