package lab09.Ex02;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> requests = new ArrayList<>();

        requests.add("Can I please get a veggie burger?");
        requests.add("Can I please get a Pasta Carbonara?");
        requests.add("Can I please get a PLAIN pizza, no toppings!?");
        requests.add("Can I please get a sushi nigiri and sashimi?");
        requests.add("Can I please get a salad with tuna?");
        requests.add("Can I please get a strawberry ice cream and waffles dessert?");

        Chef chef = new SushiChef().setSuccessor(new PastaChef().setSuccessor(new BurgerChef().setSuccessor(new PizzaChef().setSuccessor(new DessertChef()))));

        for (String request : requests){
            System.out.println();
            System.out.println(request);
            chef.chef(request);
            System.out.println();
        }
    }
    
}
