package lab09.Ex02;

public class PizzaChef extends Chef{

    @Override
    public void chef(String request) {
        if (canHandleRequest(request, "pizza")) {

            String prefix = "Can I please get a ";
            int startIndex = request.indexOf(prefix) + prefix.length();

            System.out.println("PizzaChef: Starting to cook " + request.substring(startIndex, request.length() - 1)
                    + ". Out in 7 minutes!");
        } else {
            System.out.println("PizzaChef: I can't cook that.");
            super.chef(request);
        }
    }
    
}
