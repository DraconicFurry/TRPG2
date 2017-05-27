package com;
import items.*;
import helpers.Input;
import items.Inventory;
import items.StackItem;

public class ShopMenu {
	
	public static void shopMenu(Player player) throws InventoryFullException, InsufficientItemException {
		// WE NEED AN ARRAY OF ITEMS OR WHATEVER THE DUDE SELLS
		//Im thinking the shop guy has his own "inventory" which gets displayed
		// This is a temp one just for practice purposes
		// We can establish it wherever I'm thinking that it updates every time you clear a dungeon/fight
		// But to make it truly random we would need that array of possible Items from which it would take random Items
		Inventory shopInv = new Inventory(5);
		shopInv.add(new StackItem("Hobgoblin Horn", 3, 10));
		shopInv.add(new Weapon("Skeleton Arm", 15, 10, 20, false, false));
		shopInv.add(new ResourceItem("Iron", 7, 5));
		System.out.println("You have " + player.gold + "g\n");
		showShopInv(shopInv);
		
		while (true) {
			System.out.println("1: Buy");
			System.out.println("2: Sell");
			System.out.println("3: Back");
			int shopMenuChoice = Input.validIntPrompt("shop choice", 3);
			switch (shopMenuChoice) {
				case 1:
					int shopBuyChoice = Input.validIntPrompt("item to buy", shopInv.getInv().length);
					if (shopInv.getInv()[shopBuyChoice] instanceof StackItem) {
						StackItem temp = (StackItem) shopInv.getInv()[shopBuyChoice];
						int buyNumber = Input.validIntPrompt("number to buy", temp.getAmount());
						int firstStackNum = temp.getAmount(); 
						temp.changeAmount(buyNumber);
						player.inv.add(temp);
						temp.changeAmount(firstStackNum - buyNumber);
						player.reward(temp.getValue() * buyNumber * -1, 0);
					} else {
						player.inv.add(shopInv.getInv()[shopBuyChoice]);
						shopInv.trash(shopBuyChoice, 1);
						shopInv.sortInv();
						player.reward(shopInv.getInv()[shopBuyChoice].getValue() * -1, 0);
					}
					break;
					
				case 2:
					player.inv.display();
					int toSellIndex = Input.validIntPrompt("item to sell", player.inv.getInv().length);
	                if (player.inv.getInv()[toSellIndex] instanceof StackItem) {
	                	StackItem temp = (StackItem) player.inv.getInv()[toSellIndex];
	                    int toSellNum = Input.validIntPrompt("number to throw away", temp.getAmount());
	                    	player.reward(player.inv.trash(toSellIndex, toSellNum), 0);
	                } else {
	                	try {
	                		player.inv.trash(toSellIndex, 1);
	                	} catch (Exception ex) {
	                	}
	                }	
	                break;
				case 3:
					return;
			}
		}
	}
	
	public static void showShopInv(Inventory shopInv) {
		System.out.println("------------Shop-------------");
		for (int i = 0; i < shopInv.getInv().length; i++) {
			System.out.println(i + ": " + shopInv.getInv()[i].toString());;
		}
	}
}
