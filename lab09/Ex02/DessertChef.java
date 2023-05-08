package lab09.Ex02;

public class DessertChef extends Chef {
    
    @Override
    public void chef(String request) {
        if (canHandleRequest(request, "dessert")){

            String prefix = "Can I please get a ";
            int startIndex = request.indexOf(prefix) + prefix.length();

            System.out.println("DessertChef: Starting to cook " + request.substring(startIndex, request.length()-1) + ". Out in 17 minutes!");
        }
        else{
            System.out.println("DessertChef: I can't cook that.");
            super.chef(request);
        }
    }
    
}
