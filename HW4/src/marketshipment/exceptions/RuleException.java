package marketshipment.exceptions;

public class RuleException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RuleException() {
		super("Something is wrong.");
	}
	
	public RuleException(String message) {
		super(message);
	}

}
