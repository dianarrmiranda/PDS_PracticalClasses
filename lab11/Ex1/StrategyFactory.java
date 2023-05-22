package lab11.Ex1;

public class StrategyFactory {
    public Strategy createStrategy(String attribute) {
        if (attribute.equals("price")) {
            return new PriceSortingStrategy();
        } else if (attribute.equals("processor")) {
            return new ProcessorSortingStrategy();
        } else if (attribute.equals("memory")) {
            return new MemorySortingStrategy();
        } else {
            throw new IllegalArgumentException("Attribute not supported");
        }
    }
}
