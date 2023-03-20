package lab05.Ex2;

public class CakeMaster {

    private CakeBuilder cakeBuilder;
    private Cake cake;


    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    public void createCake(String message) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(message);
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cake = cakeBuilder.getCake();
    }

    public void createCake(int n_layer, String message) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(message);
        for (int i = 0; i < n_layer; i++) {
            cakeBuilder.addCakeLayer();
        }
        if (n_layer > 1) {
            cakeBuilder.addCreamLayer();
        }
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cake = cakeBuilder.getCake();
    }

    public void createCake(Shape square, int n_layer, String message) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(message);
        for (int i = 0; i < n_layer; i++) {
            cakeBuilder.addCakeLayer();
        }
        if (n_layer > 1) {
            cakeBuilder.addCreamLayer();
        }
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.setCakeShape(square);
        cake = cakeBuilder.getCake();
    }

    public Cake getCake() {
        return cake;
    }


    
}
