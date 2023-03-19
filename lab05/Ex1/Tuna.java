package lab05.Ex1;

public class Tuna extends PortionFactory{
    Tuna(){
        this.setTemperature(Temperature.COLD);
        this.setState(State.Solid);
    }

    @Override
    public String toString() {
        return "Tuna: Temperature " + this.getTemperature() + ", State " + this.getState() ;
    }
}
