package lab05.Ex1;

public class PlasticBag extends Container{
    PlasticBag(Portion menu){
        super(menu);
    }

    @Override
    public String toString() {
        return "PlasticBag with portion = " + getPortion().toString() ;
    }
}
