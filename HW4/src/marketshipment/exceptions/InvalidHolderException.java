package marketshipment.exceptions;

public class InvalidHolderException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidHolderException() {
		super("Execption Code: 2 - You Can't Load This Element To This Holder!");
	}
	
	public InvalidHolderException(String message) {
		super(message);
	}
}