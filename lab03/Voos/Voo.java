package lab03.Voos;

import java.util.List;

public class Voo {

    private String code;
    private Aviao plane;
    private List<String> reservas;

    public Voo(String code, Aviao plane, List<String> reservas) {
        this.code = code;
        this.plane = plane;
        this.reservas = reservas;
    }


    public void countReservas() {

    }

    public String toString(){
        return "Código de voo " + code + "\n" + plane.toString();
    }


   public String FlightCodetoString() {
        return code;
    }
    
}
