package lab09.Ex02;

abstract class Chef {

    private Chef successor = null;

    public void chef(String request){
        if (successor != null){
            successor.chef(request);
        }
        else {
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }

    protected boolean canHandleRequest(String request, String food){
        return (request == null) || (request.toLowerCase().contains(food));
    }

    public Chef setSuccessor(Chef successor){
        this.successor = successor;
        return this;
    }

    
}
