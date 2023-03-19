package lab05.Ex1;

public class TermicBottle extends Container{
    TermicBottle(Portion menu){
        super(menu);
    }

    @Override
    public String toString() {
        return "TermicBottle with portion = " + getPortion().toString() ;
    }
}
