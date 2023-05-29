package lab11.Ex1;

public class StrategyFactory {
    public Strategy createStrategy(String attribute) {
        if (attribute.equals("price")) {
            System.out.println("Price");
            return new PriceSortingStrategy();
        } else if (attribute.equals("processor")) {
            System.out.println("Processor");
            return new ProcessorSortingStrategy();
        } else if (attribute.equals("memory")) {
            System.out.println("Memory");
            return new MemorySortingStrategy();
        } else {
            throw new IllegalArgumentException("Attribute not supported");
        }
    }
}
