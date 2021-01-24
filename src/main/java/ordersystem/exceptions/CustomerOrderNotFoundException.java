package ordersystem.exceptions;

public class CustomerOrderNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CustomerOrderNotFoundException() {
		super();
	}

	public CustomerOrderNotFoundException(String message) {
		super(message);
	}

	public CustomerOrderNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
