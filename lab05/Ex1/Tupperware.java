package lab05.Ex1;

public class Tupperware extends Container{
    Tupperware(Portion menu){
        super(menu);
    }

    @Override
    public String toString() {
        return "Tupperware with portion = " + getPortion().toString() ;
    }   
}
