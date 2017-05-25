package com;
import items.*;
import items.consumables.*;
import items.armor.*;
import helpers.*;

public class DungeonBreak {
	
	public  static void dungeonBreak(Player player) {
		System.out.println("1: Continue");
		System.out.println("2: Use Item");
		System.out.println("3: Quit");
		int breakChoice = Input.validIntPrompt("action", 3);
		
		switch (breakChoice) {
			case 1:
				//MOVE ON
				break;
			case 2:
				// I really dont feel like figuring this out right now
				break;
			case 3: 
				// End Dungeon Whatever. IDK how we're gonna do it. but lets do it.
				break;
		}
		
	}
}
