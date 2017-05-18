package com; 
import items.*;
import items.consumables.*;
import items.armor.*;

// @ MARTIN PUT THIS INTO THE REGULAR RUNGAME SHIT KK? ALSO UR PLAYER IS LOCAL TO UR SWITCHBLOCK WHERE IT IS CREATED!
// BUT IM ALSO MAKING THIS A STATIC CLASS JUST IN CASE U WANNA MAKE IT LIKE THAT. BUT PASS DAT PLAYER IN!

public class InventoryMenu {
    
    public static void invMenu(Player player) {
        boolean back = false;
        while (!back) {
            player.inv.display();
            
            System.out.println("1: Display");
            System.out.println("2: Sell");
            System.out.println("3: Equip");
            System.out.println("4: Throw Away");
            System.out.println("5: Back");
            int invChoice = Input.validIntPrompt("Inventory Action", 5);
            System.out.println();

            switch (invChoice) {
                case 1:
                    player.inv.display();
                    break;
                case 2:
                    int toSellIndex = Input.validIntPrompt("item's number", player.inv.getInv().length);
                    if (player.inv.getInv()[toSellIndex] instanceof StackItem) {
                        int toSellNum = Input.validIntPrompt("number to sell", player.inv.getInv()[toSellIndex].getAmounnt());
                        player.reward(player.inv.trash(toSellIndex, toSellNum), 0);
                    } else {
                        player.reward(player.inv.trash(toSellIndex, 1), 0);
                    }
                    break;
                case 3:
                    int toEquipIndex = input.validIntPrompt("item to equip", player.inv.getInv().length);
                    try {
                        if (player.inv.getInv()[toEquipIndex] instanceof Weapon) {
                            player.equipWep(toEquipIndex);
                        } else {
                            player.equipArmor(toEquipIndex);
                        }
                    } catch (Exception ex) {
                        System.out.println("Not a weapon or armor");
                    }
                    break;
                case 4: 
                    int toTrashIndex = Input.validIntPrompt("item's number", player.inv.getInv().length);
                    if (player.inv.getInv()[toTrashIndex] instanceof StackItem) {
                        int toSellNum = Input.validIntPrompt("number to throw away", player.inv.getInv()[toSellIndex].getAmounnt());
                        player.inv.trash(toSellIndex, toSellNum);
                    } else {
                        player.inv.trash(toSellIndex, 1);
                    }
                    break;
                case 5:
                    back = true;
                    break;
            }
            System.out.println();
        }
    }
}
