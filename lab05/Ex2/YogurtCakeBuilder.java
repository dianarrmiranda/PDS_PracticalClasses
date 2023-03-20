package lab05.Ex2;

public class YogurtCakeBuilder implements CakeBuilder{

    private Cake yogurtCake;

    @Override
    public void setCakeShape(Shape shape) {
        yogurtCake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        yogurtCake.addLayers();
    }

    @Override
    public void addCreamLayer() {
        int n = yogurtCake.getLayers();

        if(n == 1) {
            Cream cream = new Cream(null);
            yogurtCake.addCreamLayer(cream);
        }else{
            Cream cream = new Cream("Vanilla");
            yogurtCake.addCreamLayer(cream);
        }
    }

    @Override
    public void addTopLayer() {
        Cream cream = new Cream("Red_Berries");
        yogurtCake.addTopLayer(cream);
    }

    @Override
    public void addTopping() {
        Topping topping = new Topping("Chocolate");
        yogurtCake.addTopping(topping);
    }

    @Override
    public void addMessage(String m) {
        yogurtCake.addMessage(m);
    }

    @Override
    public void createCake() {
        yogurtCake = new Cake("Yogurt");
    }

    @Override
    public Cake getCake() {
        return yogurtCake;
    }
    
}
