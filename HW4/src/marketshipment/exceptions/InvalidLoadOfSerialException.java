package marketshipment.exceptions;

public class InvalidLoadOfSerialException extends Exception {

	public InvalidLoadOfSerialException() {
		super("Exception Code: 2 - Can not load element twice!");
	}

	public InvalidLoadOfSerialException(String message) {
		super(message);
	}
}
