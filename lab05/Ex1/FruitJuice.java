package lab05.Ex1;

public class FruitJuice extends PortionFactory{
    private String FruitName;
    FruitJuice(String ft){
        this.setTemperature(Temperature.COLD);
        this.setState(State.Liquid);
        this.FruitName = ft;
    }

    @Override
    public String toString() {
        return "FruitJuice: " + FruitName+ ", Temperature " + this.getTemperature() + ", State " + this.getState() ;
    }
    
    
}
