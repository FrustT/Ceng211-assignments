package marketshipment.exceptions;

public class InvalidBoxException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidBoxException() {
		super("Execption Code: 2 - You Can't Load This Item To This Box!");
	}
	
	public InvalidBoxException(String message) {
		super(message);
	}
}