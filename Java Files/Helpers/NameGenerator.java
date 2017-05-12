public class NameGenerator {

    private String[] rangedPrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic"};
    private String[] magicPrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic", "Apprentice's", "Master's"};
    private String[] meleePrefixes = new String[] {"Edgy", "Enchanted", "Burning", "Frozen", "Electric", "Blooming", "Arcane", "Demonic", "Angelic", "Runic", "Sharp", "Heavy", "Weighted", "Polished"};
    private String[] rangedWeapons = new String[] {"Bow", "Gun", "Crossbow", "Javelin"};
    private String[] magicWeapons = new String[] {"Staff", "Rod", "Wand", "Scepter"};
    private String[] meleeWeapons = new String[] {"Sword", "Knife", "Mace", "Axe", "Spear", "Warhammer", "Trident"};
    
    public static String generateWepName(boolean isRanged, boolean isMagic) {
        String prefix;
        String wepType;
        
        if (isRanged) {
            if (isMagic) {
                prefix = magicPrefixes[(int)(Math.random() * rangedPrefixes.length)];
                wepType = magicWeapons[(int)(Math.random() * rangedWeapons.length)];
            } else {
                prefix = rangedPrefixes[(int)(Math.random() * rangedPrefixes.length)];
                wepType = rangedWeapons[(int)(Math.random() * rangedWeapons.length)];
            }
        } else {
            prefix = meleePrefixes[(int)(Math.random() * meleePrefixes.length)];
            wepType = meleeWeapons[(int)(Math.random() * meleeWeapons.length)];
        }
        
        return (prefix + " " + wepType);
    }
}
