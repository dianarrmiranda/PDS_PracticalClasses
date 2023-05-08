package lab09.Ex02;

public class SushiChef extends Chef{

    @Override
    public void chef(String request) {
        if (canHandleRequest(request, "sushi")) {

            String prefix = "Can I please get a ";
            int startIndex = request.indexOf(prefix) + prefix.length();

            System.out.println("SushiChef: Starting to cook " + request.substring(startIndex, request.length() - 1)
                    + ". Out in 14 minutes!");
        } else {
            System.out.println("SushiChef: I can't cook that.");
            super.chef(request);
        }
    }
    
}
