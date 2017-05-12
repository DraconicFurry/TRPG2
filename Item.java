public abstract class Item {
    
    private String name;
    private int goldValue;

    public Item(name, value, number) {
        this.name = name;
        this.value = value;
        this.number = numer;
    }
    
    public String toStrng() {
        System.out.println(name + " (" + value + " g" + ")"); 
    }
}
