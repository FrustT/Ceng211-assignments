package marketshipment.exceptions;

public class CannotBeAddedToHolderException extends RuleException {
	
	public CannotBeAddedToHolderException() {
		super("Execption Code: 3 - You Cannot Load This Element To This Holder!");
	}
	
	public CannotBeAddedToHolderException(String message) {
		super(message);
	}
}
