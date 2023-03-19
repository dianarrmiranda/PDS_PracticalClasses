package lab05.Ex1;

public abstract class PortionFactory implements Portion {
    private State state;
    private Temperature temp;

    public State getState() {
        return this.state;
    }

    public Temperature getTemperature() {
        return this.temp;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setTemperature(Temperature temp) {
        this.temp = temp;
    }

    public static Portion create(String Type, Temperature temp){
        if (Type.equals("Beverage")) {
            switch (temp) {
                case COLD:
                    return new FruitJuice("Orange"); // é o que está no exemplo, mas talvez se tenha de tornar mais genérico
                case WARM:
                    return new Milk();
                default:
                    System.out.println("Error! Unknown Temperature enum declared!");
                    System.exit(1);
            }
        } else if (Type.equals("Meat")) {
            switch (temp) {
                case COLD:
                    return new Tuna();
                case WARM:
                    return new Pork();
                default:
                    System.out.println("Error! Unknown Temperature enum declared!");
                    System.exit(1);
            }
        } else {
                System.out.println("Not beverage or meat!");
                System.exit(1);
        }   
        return null;
    }
}
