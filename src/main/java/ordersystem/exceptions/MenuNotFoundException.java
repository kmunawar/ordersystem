package ordersystem.exceptions;

public class MenuNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MenuNotFoundException() {
		super();
	}

	public MenuNotFoundException(String message) {
		super(message);
	}
	
	public MenuNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}