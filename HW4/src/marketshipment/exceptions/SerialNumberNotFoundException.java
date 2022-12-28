package marketshipment.exceptions;

public class SerialNumberNotFoundException extends RuleException {

	public SerialNumberNotFoundException() {
		super("Exception Code: 5 - Serial Number Cannot Found!");
	}

	public SerialNumberNotFoundException(String message) {
		super(message);
	}
}
