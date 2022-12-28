package marketshipment.exceptions;

public class InvalidBoxException extends CannotBeAddedToHolderException{
	
	public InvalidBoxException() {
		super("Execption Code: 4 - Type mismatch! You Cannot Load This Item To This Box!");
	}
	
	public InvalidBoxException(String message) {
		super(message);
	}
}