package com;
import java.util.*; 
import java.io.*;
import items.*;
import items.armor.*;
import items.consumables.*;
@SuppressWarnings(value = { "unused", "resource" })

public class SaveLoad {
	
	public static boolean stringBool(String in) {
		if (in.equals("true")) {
			return true;
		} else if (in.equals("false")) {
			return false;
		} else {
			System.out.println("ERR: Invalid boolean string");
			return false;
		}
	}
	
	public static Player readSave(int fileNum) throws FileNotFoundException, InventoryFullException {
		File[] saveFiles = new File("SaveFiles").listFiles();
		File toLoad = saveFiles[fileNum];
		Scanner sc = new Scanner(toLoad);
		String name = sc.next().replace('_', ' ');
		int level = sc.nextInt(); int XP = sc.nextInt(); int gold = sc.nextInt(); int MHP = sc.nextInt(); int HP = sc.nextInt(); int MMP = sc.nextInt(); int MP= sc.nextInt();
		Weapon wep = new Weapon(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt(), sc.nextInt(), stringBool(sc.next()), stringBool(sc.next()));
		Helmet hlm = new Helmet(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt());
		Shoulderpads sld = new Shoulderpads(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt());
		Chestpiece cst = new Chestpiece(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt());
		Leggings leg = new Leggings(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt());
		Armory army = new Armory(null);
		army.army[0] = hlm; army.army[1] = sld; army.army[2] = cst; army.army[3] = leg;
		Inventory inv = new Inventory(sc.nextInt());
		int invIndex = 0;
		while (sc.hasNext()) {
			if (sc.next().equals("cns")) {
				switch (sc.nextInt()) {
					case 1:
						inv.add(new DamageConsumable(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt(), sc.nextInt()));
						break;
					case 2:
						inv.add(new AreaDamageConsumable(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt(), sc.nextInt()));
						break;
					case 3:
						inv.add(new HealConsumable(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt(), sc.nextInt()));
						break;
					case 4:
						inv.add(new SummonConsumable(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt(), name, sc.nextInt(), sc.nextInt(), sc.nextInt(), new Weapon(
								sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt(), sc.nextInt(), stringBool(sc.next()), stringBool(sc.next()))));
						break;
				}
			} else if (sc.next().equals("res")) {
				inv.add(new ResourceItem(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt()));
			} else if (sc.next().equals("stk")) {
				inv.add(new StackItem(sc.next().replace('_', ' '), sc.nextInt(), sc.nextInt()));
			}
			invIndex++;
		}
		Player player = new Player(name, level, XP, MHP, MMP, wep, inv, gold);
		player.addArmory(army);
		army.owner = player;
		return player;
	}
	
	public static void saveGame(Player player) throws FileNotFoundException, IOException {
		File save = new File("SaveFiles/" + player.getName() + ".txt");
		if (save.exists()) {
			Scanner sc = new Scanner(save);
			//Read any data not stored in Player and print it
			save.delete();
		}
		save.createNewFile();
		PrintStream out = new PrintStream(save);
		String playerName = player.name.replace(' ', '_');
		out.print(player.name + " " + player.level + " " + player.XP + " " + player.gold + " " + player.MHP + " " + player.HP + " " + player.MMP + " " + player.MP + " ");
		Weapon wep = player.wep;
		String wepName = wep.getName().replace(' ', '_');
		out.print(wepName + " " + wep.getValue() + " "+ wep.getMin() + " " + wep.getMax() + " " + wep.getRanged() + " " + wep.getMagic() + " ");
		Helmet hlm = (Helmet) player.army.army[0];
		Shoulderpads sld = (Shoulderpads) player.army.army[1];
		Chestpiece cst = (Chestpiece) player.army.army[2];
		Leggings leg = (Leggings) player.army.army[3];
		String hlmName = hlm.getName().replace(' ', '_');
		String sldName = sld.getName().replace(' ', '_');
		String cstName = cst.getName().replace(' ', '_');
		String legName = leg.getName().replace(' ', '_');
		out.print(hlmName + " " + hlm.getValue() + " " + hlm.getDefense() + " ");
		out.print(sldName + " " + sld.getValue() + " " + sld.getDefense() + " ");
		out.print(cstName + " " + cst.getValue() + " " + cst.getDefense() + " ");
		out.print(legName + " " + leg.getValue() + " " + leg.getDefense() + " ");
		Inventory inv = player.inv;
		out.print(inv.getInv().length + " ");
		for (int i = 0; i < inv.getInv().length; i++) {
			if (inv.getInv()[i] != null) {
				Item next = inv.getInv()[i];
				String nextName = next.getName().replace(' ', '_');
				if (next == null) {

				} else if (next instanceof SummonConsumable) {
					out.print("cns " + ((Consumable)next).getType() + nextName  + " " + " " + next.getValue() + " " + ((Consumable)next).getAmount() + " " + ((SummonConsumable)next).ally.level
							+ " " + ((SummonConsumable)next).ally.HP + " " + ((SummonConsumable)next).ally.MP + " " + ((SummonConsumable)next).ally.wep.getName().replace(' ', '_') + " " 
							+ ((SummonConsumable)next).ally.wep.getValue() + " " + ((SummonConsumable)next).ally.wep.getMin() + " " + ((SummonConsumable)next).ally.wep.getMax() + " " 
							+ ((SummonConsumable)next).ally.wep.getRanged() + " " + ((SummonConsumable)next).ally.wep.getMagic());
				} else if (next instanceof Consumable) {
					out.print("cns " + ((Consumable)next).getType() + nextName  + " " + ((Consumable)next).getScale() + " " + next.getValue() + " " + ((Consumable)next).getAmount() + " ");
				} else if (next instanceof ResourceItem) {
					out.print("res " + nextName + " " + next.getValue() + " " + ((ResourceItem)next).getAmount() + " ");
				} else if (next instanceof StackItem) {
					out.print("stk " + nextName + " " + next.getValue() + " " + ((ResourceItem)next).getAmount() + " ");
				}
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
