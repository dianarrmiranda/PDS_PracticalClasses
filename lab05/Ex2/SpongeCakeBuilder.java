package lab05.Ex2;

public class SpongeCakeBuilder implements CakeBuilder{

    private Cake spongeCake;

    @Override
    public void setCakeShape(Shape shape) {
        spongeCake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        spongeCake.addLayers();
    }

    @Override
    public void addCreamLayer() {
        int n = spongeCake.getLayers();

        if(n == 1) {
            Cream cream = new Cream(null);
            spongeCake.addCreamLayer(cream);
        }else{
            Cream cream = new Cream("Red_Berries");
            spongeCake.addCreamLayer(cream);
        }
    }

    @Override
    public void addTopLayer() {
        Cream cream = new Cream("Whipped_Cream");
        spongeCake.addTopLayer(cream);
    }

    @Override
    public void addTopping() {
        Topping topping = new Topping("Fruit");
        spongeCake.addTopping(topping);
    }

    @Override
    public void addMessage(String m) {
        spongeCake.addMessage(m);
    }

    @Override
    public void createCake() {
        spongeCake = new Cake("Sponge");
    }

    @Override
    public Cake getCake() {
        return spongeCake;
    }
    
}
