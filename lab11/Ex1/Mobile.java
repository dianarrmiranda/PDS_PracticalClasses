package lab11.Ex1;

public class Mobile {
    private String name;
    private double price;
    private String processor;
    private int memory;

    public Mobile(String name, double price, String processor, int memory) {
        this.name = name;
        this.price = price;
        this.processor = processor;
        this.memory = memory;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProcessor() {
        return processor;
    }

    public int getMemory() {
        return memory;
    }
}
