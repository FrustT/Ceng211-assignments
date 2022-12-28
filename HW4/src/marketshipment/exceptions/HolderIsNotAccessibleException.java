package marketshipment.exceptions;

public class HolderIsNotAccessibleException extends CannotBeAddedToHolderException {
	
	public HolderIsNotAccessibleException() {
		super("Execption Code: 7 - You Cannot Acces To This Holder!");
	}
	
	public HolderIsNotAccessibleException(String message) {
		super(message);
	}

}
