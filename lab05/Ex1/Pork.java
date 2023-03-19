package lab05.Ex1;

public class Pork extends PortionFactory{
    Pork(){
        this.setTemperature(Temperature.WARM);
        this.setState(State.Solid);
    }

    @Override
    public String toString() {
        return "Pork: Temperature " + this.getTemperature() + ", State " + this.getState() ;
    }
    
}
