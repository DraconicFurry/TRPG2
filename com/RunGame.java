package com;
import java.util.*;
import java.io.FileNotFoundException;
import helpers.*;
import items.*;
import items.armor.*;

public class RunGame {
	public static void main(String[] args) {
		boolean quit = false;
		System.out.println("TRPG v0.0.1 initialized.\n");
		while (!quit) {
			System.out.println("1: New Character");
			System.out.println("2: Load Character");
			System.out.println("3: Help");
			System.out.println("4: Quit");
			System.out.println("5: Run Test Scenario");
			int menuChoice = Input.validIntPrompt("menu item", 5);
			System.out.println();
			switch (menuChoice) {
				case 1:
					Player player = createCharacter();
					try {
						SaveLoad.saveGame(player);
               		} catch (Exception ex) {
                  		System.out.println("Savefile creation failed.");
               		}
					runGame(player);
					break;
				case 2:
					try {
					   	SaveLoad.listFiles();
              		} catch (FileNotFoundException ex) {
                  		System.out.println("No savefiles found.");
               		}
					try {
						int fileChoice = Input.validIntPrompt("file number", SaveLoad.numFiles());
						Player loadPlayer = SaveLoad.readSave(fileChoice - 1);
						runGame(loadPlayer);
					} catch (Exception ex) {
						System.out.println("Savefile not found. Your save data may be corrupted.");
					}
					break;
				case 3:
					helpMenu();
					break;
				case 4:
					quit = true;
					break;
				case 5:
					runTest();
					break;
			}
			System.out.println();
		}
	}
	
	public static void runTest() {
		System.out.println("No test scenario loaded.");
	}
	
	public static void runGame(Player player) {
		System.out.println("This is where I would run the game, if I had written that code yet.");
	}
	
	public static Player createCharacter() {
		String name = Input.strPrompt("character name");
		Weapon meleePhys = new Weapon("Trainee's Sword", 0, 5, 10, false, false);
		Weapon rangePhys = new Weapon("Recruit's Bow", 0, 5, 10, true, false);
		Weapon meleeMagi = new Weapon("Conjured Dagger", 0, 5, 10, false, true);
		Weapon rangeMagi = new Weapon("Apprentice's Staff", 0, 5, 10, true, true);
		System.out.println("1: " + meleePhys);
		System.out.println("2: " + rangePhys);
		System.out.println("3: " + meleeMagi);
		System.out.println("4: " + rangeMagi);
		int wepChoice = Input.validIntPrompt("weapon choice", 4);
		Weapon wep;
		switch (wepChoice) {
			case 1:
				wep = meleePhys;
				break;
			case 2:
				wep = rangePhys;
				break;
			case 3:
				wep = meleeMagi;
				break;
			case 4:
				wep = rangeMagi;
				break;
			default:
				wep = meleePhys;
				break;
		}
		Player player = new Player(name, 1, 0, 50, 30, wep, new Inventory(), 0);
		Armory army = new Armory(player);
		player.addArmory(army);
		return player;
	}
	
	public static void helpMenu() {
		boolean quit = false;
		while (!quit) {
			System.out.println("1: Combat");
			System.out.println("2: Equipment");
			System.out.println("3: Stats and Leveling");
			System.out.println("4: Effects and Skills");
			System.out.println("5: Return to Menu");
			int menuChoice = Input.validIntPrompt("help topic", 5);
			System.out.println();
			switch (menuChoice) {
				case 1:
					System.out.println("Combat takes place in turns. First the player acts, then the player's allies act, then the enemies act.");
					System.out.println("This cycle repeats until all enemies are killed, the player dies, or the player runs from combat.");
					System.out.println("Each turn, the player will have the option of attacking an enemy, using a skill, using an item, or fleeing.");
					System.out.println("Regular attacks deal moderate damage, target a single enemy, and consume no mana.");
					System.out.println("Skills consume mana, but are more powerful than normal attacks, and some skills can heal or buff your team.");
					System.out.println("Items have a variety of different effects, and are consumed upon use.");
					System.out.println("If you attempt to run, you have a 50% chance to succeed. Failing to run will end your turn.");
					System.out.println("If you successfully escape from combat, you will drop half the gold you earned in the battle.");
					System.out.println("If you die, you lose all gold and XP earned since you last visited the tavern.");
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					quit = true;
					break;
			}
			System.out.println();
		}
	}
}
