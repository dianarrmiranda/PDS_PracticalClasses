package lab05.Ex2;

public class Ex2_Main {
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();
        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);// 1 cake layer
        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);// squared, 2 layers
        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);// 3 cake layers
        // you should add here other example(s) of CakeBuilder
        }
    
}
