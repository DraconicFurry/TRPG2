public class NameGenerator {

    private String[] rangedPrefixes = new String["Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic", "Apprentice's", "Master's"];
    private String[] meleePrefixes = new String["Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic", "Sharp", "Heavy", "Weighted", "Polished"];
    private String[] rangedWeapons = new String["Staff", "Rod", "Wand", "Scepter", "Bow", "Gun", "Crossbow", "Javelin"];
    private String[] meleeWeapons = new String["Sword", "Knife", "Mace", "Axe", "Spear", "Warhammer", "Trident"];
    
    public String generateWepName(boolean isRanged) {
        String prefix;
        String wepType;
        
        if (isRanged) {
            prefix = rangedPrefixes[(int)(Math.Random() * rangedPrefixes.length)];
            wepType = rangedWeapons[(int)(Math.Random() * rangedWeapons.length)];
        } else {
            prefix = meleePrefixes[(int)(Math.Random() * meleePrefixes.length)];
            wepType = meleeWeapons[(int)(Math.Random() * meleeWeapons.length)];
        }
        
        return (prefix + " " + wepType);
    }
}