public class Inventory {

    private Item[] inv;

    public Inventory() {
        inv = new Item[10];
    }

    public void add(Item newItem) {
        boolean added = false;
        for (int i = 0; i < inv.length; i++) {
            if (inv[i].getName == newItem.getName && inv[i] instanceof StackItem) {
                inv[i].add(newItem.getAmount());
                added = true;
            } else if (inv[i] == null) {
                inv[i] = newItem;
                added = true;
            }
        }
        
        if (!added) {
            throw new InventoryFullException;
        }
        
    }
    
    public int trash(int index, int num) {
        index -= 1;
        
        int returnValue = inv[index].getValue() * num;
        
        if (inv[index] instanceof StackItem) {
            inv[index].remove(num); 
            
            if (inv[index].getAmount < 0) {
                throw new InsufficentItemException;
            } else if (inv[index].getAmount = 0) {
                inv[index] = null;    
            }
        } else {
            inv[index] = null;
        }
        sortInv();
        
        return returnValue;
    }
    
    public String display() {
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                System.out.println((i + 1) + ": None");
            } else {
                System.out.println((i + 1) + ": " + inv[i].toString());
            }
        }
    }
    
    public void increaseSize(int added) {
        Item[] tempInv = new Item[inv.length + added];
        
        for (int i = 0; i < inv.length; i++) {
            tempInv[i] = inv[i];
        }
        
        inv = tempInv;
    }
    
    private void sortInv() {
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                for (int j = i; j < inv.length - 1; j++) {
                    inv[i] = inv[i + 1];
                }
                inv[inv.length - 1] = null;
                i -= 1;
            }
        }
    }
}
