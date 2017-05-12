public class NameGenerator {

    private String[] rangedPrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic"};
    private String[] magicPrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic", "Apprentice's", "Master's"};
    private String[] meleePrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic", "Sharp", "Heavy", "Weighted", "Polished"};
    private String[] rangedWeapons = new String[] {"Bow", "Gun", "Crossbow", "Javelin"};
    private String[] magicWeapons = new String[] {"Staff", "Rod", "Wand", "Scepter"};
    private String[] meleeWeapons = new String[] {"Sword", "Knife", "Mace", "Axe", "Spear", "Warhammer", "Trident}";
    
    public static String generateWepName(boolean isRanged) {
        String prefix;
        String wepType;
        
        if (isRanged) {
            if (isMagic) {
                prefix = magicPrefixes[(int)(Math.Random() * rangedPrefixes.length)];
                wepType = magicWeapons[(int)(Math.Random() * rangedWeapons.length)];
            } else {
                prefix = rangedPrefixes[(int)(Math.Random() * rangedPrefixes.length)];
                wepType = rangedWeapons[(int)(Math.Random() * rangedWeapons.length)];
            }
        } else {
            prefix = meleePrefixes[(int)(Math.Random() * meleePrefixes.length)];
            wepType = meleeWeapons[(int)(Math.Random() * meleeWeapons.length)];
        }
        
        return (prefix + " " + wepType);
    }
}
