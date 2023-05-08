package lab09.Ex02;

public class PastaChef extends Chef {

    @Override
    public void chef(String request) {
        if (canHandleRequest(request, "pasta")) {

            String prefix = "Can I please get a ";
            int startIndex = request.indexOf(prefix) + prefix.length();

            System.out.println("PastaChef: Starting to cook " + request.substring(startIndex, request.length() - 1)
                    + ". Out in 14 minutes!");
        } else {
            System.out.println("PastaChef: I can't cook that.");
            super.chef(request);
        }
    }

}
