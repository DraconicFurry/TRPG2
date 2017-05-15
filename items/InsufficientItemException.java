package items;

public class InsufficientItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 378501028619674528L;

	public InsufficientItemException() {
	
	}
	
	public InsufficientItemException(String message) {
		super(message);
	}
}
