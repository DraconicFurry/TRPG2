package items;
import items.consumables.*;
import items.armor.*;
import helpers.*;
import java.util.*;

public class Inventory {

    private Item[] inv;

    public Inventory() {
        inv = new Item[10];
    }
    
    public Item[] getInv() {
      return inv;
    }    
    
    public void add(Item newItem) throws InventoryFullException {
        int i = 0;
        boolean added = false;
        while (!added && i < inv.length) {
            if (inv[i] instanceof StackItem && inv[i].getName() == newItem.getName()) {
                StackItem si = (StackItem)inv[i];
                StackItem nsi = (StackItem)newItem;
                si.add(nsi.getAmount());
                added = true;
            } else if (inv[i] == null) {
                inv[i] = newItem;
                added = true;
            }
            i++;
        }
        
        if (!added) {
            throw new InventoryFullException();
        }
        
    }
    
    public int trash(int index, int num) throws InsufficientItemException {
        int returnValue = 0;
        index -= 1;
       
        try {
            returnValue = inv[index].getValue() * num;
        } catch (Exception ex) {
        }    
            
        if (inv[index] instanceof StackItem) {
            StackItem si = (StackItem)inv[index];
            si.remove(num); 
            
            if (si.getAmount() < 0) {
                throw new InsufficientItemException();
            } else if (si.getAmount() == 0) {
                inv[index] = null;    
            }
        } else {
            inv[index] = null;
        }
        sortInv();
        
        return returnValue;
    }
    
    public void display() {
        System.out.println("----------Inventory----------");
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                System.out.println((i + 1) + ": None");
            } else {
                System.out.println((i + 1) + ": " + inv[i].toString());
            }
        }
        System.out.println("-----------------------------");
    }
    
    public void increaseSize(int added) {
        Item[] tempInv = new Item[inv.length + added];
        
        for (int i = 0; i < inv.length; i++) {
            tempInv[i] = inv[i];
        }
        
        inv = tempInv;
    }
    
    public void sortInv() {
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                for (int j = i; j < inv.length - 1; j++) {
                    inv[i] = inv[i + 1];
                }
                inv[inv.length - 1] = null;
                i -= 1;
            }
        }
        
        List<Item> invList = Arrays.asList(inv);   
        
        try {
            Collections.sort(invList);
        } catch (Exception ex) {
        }
        for (int i = 0; i < inv.length; i++) {
            inv[i] = invList.get(i);    
        }
    }
}
