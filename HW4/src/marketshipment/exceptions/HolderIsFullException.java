package marketshipment.exceptions;

public class HolderIsFullException extends CannotBeAddedToHolderException {
	
	public HolderIsFullException() {
		super("Execption Code: 6 - The Holder Is Full! You Cannot Load This Element To This Holder!");
	}
	
	public HolderIsFullException(String message) {
		super(message);
	}
}
