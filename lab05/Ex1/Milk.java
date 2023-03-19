package lab05.Ex1;

public class Milk extends PortionFactory {
    Milk(){
        this.setTemperature(Temperature.WARM);
        this.setState(State.Liquid);
    }

    @Override
    public String toString() {
        return "Milk: Temperature " + this.getTemperature() + ", State " + this.getState() ;
    }
}
