package helpers;
import items.*;
import items.armor.*;
import items.consumables.*;
import com.Player;

public class BagChecker {

	public static boolean checkForItem(Player player) {
		for (int i = 0; i < player.inv.getInv().length; i++){
			if (player.inv.getInv()[i] instanceof Item) {
				return true;
			}
			System.out.println("You do not have any items in your bag");
			return false;
		}
		return false;
	}
	
	public static boolean checkForArmor(Player player) {
		for (int i = 0; i < player.inv.getInv().length; i++) {
			if (player.inv.getInv()[i] instanceof Armor || player.inv.getInv()[i] instanceof Weapon) {
				return true;
			}
			System.out.println("You do not have any weapons or armor in your bag");
			return false;
		}
		return false;
	}
	
	public static boolean checkForConsumables(Player player) {
		for (int i = 0; i < player.inv.getInv().length; i++) {
			if (player.inv.getInv()[i] instanceof Consumable) {
				return true;
			}
			System.out.println("You do not have any consumable items in your bag");
			return false;
		}
		return false;
	}
}
