package marketshipment.exceptions;

public class LoadIsAlreadyLoadedException extends CannotBeAddedToHolderException {

	public LoadIsAlreadyLoadedException() {
		super("Exception Code: 2 - Load Is Already Loaded!");
	}

	public LoadIsAlreadyLoadedException(String message) {
		super(message);
	}
}
