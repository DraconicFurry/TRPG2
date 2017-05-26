package com;
import java.util.*; 
import java.io.*;
import items.*;
import items.armor.*;
import items.consumables.*;
@SuppressWarnings(value = { "unused", "resource" })

public class SaveLoad {
	
	public static Player readSave(int fileNum) throws FileNotFoundException {
		File[] saveFiles = new File("SaveFiles").listFiles();
		File toLoad = saveFiles[fileNum];
		Scanner sc = new Scanner(toLoad);
		return new Player("Test", 1, 50, 30);
	}
	
	public static void saveGame(Player player) throws FileNotFoundException, IOException {
		File save = new File("SaveFiles/" + player.getName() + ".txt");
		if (save.exists()) {
			Scanner sc = new Scanner(save);
			//Read necessary data from existing savefile
			save.delete();
		}
		save.createNewFile();
		PrintStream out = new PrintStream(save);
		out.print(player.name + " " + player.level + " " + player.XP + " " + player.MHP + " " + player.HP + " " + player.MMP + " " + player.MP + " ");
		Weapon wep = player.wep;
		out.print(wep.getName() + " " + wep.getValue() + wep.getMin() + " " + wep.getMax() + " " + wep.getRanged() + " " + wep.getMagic() + " ");
		Helmet hlm = (Helmet) player.army.army[0];
		Shoulderpads sld = (Shoulderpads) player.army.army[1];
		Chestpiece cst = (Chestpiece) player.army.army[2];
		Leggings leg = (Leggings) player.army.army[3];
		out.print(hlm.getName() + " " + hlm.getValue() + " " + hlm.getDefense() + " ");
		out.print(sld.getName() + " " + sld.getValue() + " " + sld.getDefense() + " ");
		out.print(cst.getName() + " " + cst.getValue() + " " + cst.getDefense() + " ");
		out.print(leg.getName() + " " + leg.getValue() + " " + leg.getDefense() + " ");
		Inventory inv = player.inv;
		for (int i = 0; i < inv.getInv().length; i++) {
			Item next = inv.getInv()[i];
			if (next == null) {

			} else if (next instanceof Consumable) {
				out.print("cns " + next.getName() + " " + next.getValue() + " " + ((Consumable)next).getType()  + " " + ((Consumable)next).getScale() + " ");
			} else if (next instanceof ResourceItem) {
				out.print("res " + next.getName() + " " + next.getValue() + " " + ((ResourceItem)next).getAmount() + " ");
			} else if (next instanceof StackItem) {
				out.print("stk " + next.getName() + " " + next.getValue() + " " + ((ResourceItem)next).getAmount() + " ");
			}
		}
	}
	
	public static void listFiles() throws FileNotFoundException {
		File saveFolder = new File("SaveFiles");
		File[] saveFiles = saveFolder.listFiles();
		Scanner sc;
		for (int i = 0; i < saveFiles.length; i++) {
			sc = new Scanner(saveFiles[i]);
			System.out.println((i + 1) + ": " + sc.next());
		}
	}
	
	public static int numFiles() throws FileNotFoundException {
		return new File("SaveFiles").listFiles().length;	
	}
}
