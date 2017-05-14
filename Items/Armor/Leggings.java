imports Items.*;
package Armor;

public class Leggings extends Armor {

    public Leggings(String name, int value, int defense) {
      super(name, value, defense);
    }
    
    public String toString() {
        return ("(Leggings) " + getName() + ": " + getDefense() + " armor");
    }   
}
