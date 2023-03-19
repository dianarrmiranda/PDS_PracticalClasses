package lab05.Ex1;

public class PlasticBottle extends Container {
    PlasticBottle(Portion menu){
        super(menu);
    }

    @Override
    public String toString() {
        return "PlasticBottle with portion = " + getPortion().toString() ;
    }  
}
