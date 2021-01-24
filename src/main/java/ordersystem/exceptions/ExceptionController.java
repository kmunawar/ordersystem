package ordersystem.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(value = CustomerOrderNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerOrderNotFoundException exception) {
		logger.error("Customer Order Not Found Exception: ", exception.getMessage());
		return new ResponseEntity<>("Customer order not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MenuNotFoundException.class)
	public ResponseEntity<Object> exception(MenuNotFoundException exception) {
		logger.error("Menu Not Found Exception: ", exception.getMessage());
		return new ResponseEntity<>("Menu not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UnauthorizedException.class)
	public ResponseEntity<Object> exception(UnauthorizedException exception) {
		logger.error("Unauthorized Exception: ", exception.getMessage());
		return new ResponseEntity<>("Incorrect username and/or password", HttpStatus.UNAUTHORIZED);
	}
	
}
