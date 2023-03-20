package lab05.Ex2;

public class Cake {

    private Shape shape = Shape.Circle;
    private int layers = 1;
    private String message;
    private Topping topping;
    private Cream creamLayer;
    private Cream creamTop;
    private final String name;

    public Cake(String name) {
        this.name = name;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void addLayers() {
        layers++;

    }

    public int getLayers() {
        return layers;
    }

    public void addCreamLayer(Cream cream) {
        this.creamLayer = cream;
    }

    public void addTopLayer(Cream cream) {
        this.creamTop = cream;
    }

    public void addTopping(Topping topping) {
        this.topping = topping;
    }

    public void addMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String s = name;

        if (layers > 1) {
            s += " cake with " + (layers - 1) + " layers";
        }

        if (creamLayer !=  null) {
            s += ", " + creamLayer + " cream";
        }

        if (creamTop != null) {
            s += ", topped with " + creamTop + " cream";
        }

        if (topping != null) {
            s += " and " + topping;
        }

        if (message != null) {
            s += ". Message says: \"" + message + "\".";
        }

        s += "\n";

        return s;
    }







    
}
