package lab05.Ex2;

public class ChocolateCakeBuilder implements CakeBuilder{

    protected Cake chocolateCake;

    @Override
    public void setCakeShape(Shape shape) {
        chocolateCake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        chocolateCake.addLayers();
    }

    @Override
    public void addCreamLayer() {
        int n = chocolateCake.getLayers();

        if(n == 1) {
            Cream cream = new Cream(null);
            chocolateCake.addCreamLayer(cream);
        }else{
            Cream cream = new Cream("Chocolate");
            chocolateCake.addCreamLayer(cream);
        }
    }

    @Override
    public void addTopLayer() {
        Cream cream = new Cream("Whipped_Cream");
        chocolateCake.addTopLayer(cream);
    }

    @Override
    public void addTopping() {
        Topping topping = new Topping("Fruit");
        chocolateCake.addTopping(topping);
    }

    @Override
    public void addMessage(String message) {
        chocolateCake.addMessage(message);
    }

    @Override
    public void createCake() {
        chocolateCake = new Cake("Soft Chocolate");
    }

    @Override
    public Cake getCake() {
        return chocolateCake;
    }
    
}
