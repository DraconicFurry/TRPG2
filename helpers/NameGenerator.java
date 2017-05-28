package helpers;

public class NameGenerator {

    private static String[] rangedPrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic"};
    private static String[] magicPrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic", "Apprentice's", "Master's"};
    private static String[] meleePrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic", "Sharp", "Heavy", "Weighted", "Polished"};
	private static String[] magMeleePrefixes = new String[] {"Summoned", "Conjured", "Energy", "Spirit", "Manaforged", "Spellsword's"};
    private static String[] rangedWeapons = new String[] {"Bow", "Gun", "Crossbow", "Javelin"};
    private static String[] magicWeapons = new String[] {"Staff", "Rod", "Wand", "Scepter"};
    private static String[] meleeWeapons = new String[] {"Sword", "Knife", "Mace", "Axe", "Spear", "Warhammer", "Trident"};
    private static String[] monsterPrefixes = new String[] {"Orc", "Troll", "Goblin", "Elf", "Slime", "Demon", "Elemental", "Shadow", "Gnome", "Dwarf", "Undead", "Imp", "Feline", "Lizard", "Rogue"};
    private static String[] monsterSuffixes = new String[] {"Warrior", "Rogue", "Archer", "Hunter", "Mage", "Spellslinger", "Guard", "Blacksmith", "Shieldbearer", "Berserker", "Guardian", "Sorcerer", "Warlock", "Summoner", "Werewolf"}; 

    public static String generateWepName(boolean isRanged, boolean isMagic) {
        String prefix;
        String wepType;
        
        if (isRanged) {
            if (isMagic) {
                prefix = magicPrefixes[(int)(Math.random() * magicPrefixes.length)];
                wepType = magicWeapons[(int)(Math.random() * magicWeapons.length)];
            } else {
                prefix = rangedPrefixes[(int)(Math.random() * rangedPrefixes.length)];
                wepType = rangedWeapons[(int)(Math.random() * rangedWeapons.length)];
            }
        } else {
            if (isMagic) {
				prefix = magMeleePrefixes[(int)(Math.random() * magMeleePrefixes.length)];
			} else {
            	prefix = meleePrefixes[(int)(Math.random() * meleePrefixes.length)];
			}
			wepType = meleeWeapons[(int)(Math.random() * meleeWeapons.length)];
        }
        
        return (prefix + " " + wepType);
    }
    
    public static String generateMonsterName() {
    	return ((monsterPrefixes[(int)(Math.random() * monsterPrefixes.length)]) + (monsterSuffixes[(int)(Math.random() * monsterSuffixes.length)]));
    }
}
