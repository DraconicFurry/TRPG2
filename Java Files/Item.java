public abstract class Item {
    
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.goldValue = value;
    }
    
    public String getName() {
        return name;    
    }
    
    public String getValue() {
        return value;
    }
    
    public String toStrng() {
        System.out.println(name + " (" + value + "g" + ")"); 
    }
}
