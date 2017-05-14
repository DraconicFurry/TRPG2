package Items;

public class InsufficientItemException extends Exception {

	public InsufficientItemException() {
	
	}
	
	public InsufficientItemException(String message) {
		super(message);
	}
}
