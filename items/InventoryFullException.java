package items;

public class InventoryFullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5345933921756086236L;

	public InventoryFullException() {
	
	}
	
	public InventoryFullException(String message) {
		super(message);
	}
}
