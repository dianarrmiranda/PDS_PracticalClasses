package lab03.Voos;

import java.util.List;

public class Voo {

    private String code;
    private Aviao plane;
    private List<String> reservas;

    public Voo() {}

    public Voo(String code, Aviao plane, List<String> reservas) {
        this.code = code;
        this.plane = plane;
        this.reservas = reservas;
    }

    public Voo(String code, Aviao plane) { // Para a op F, não é preciso saber as reservas
        this.code = code;
        this.plane = plane;
    }

    public String setCode(String code) {
        return this.code = code;
    }

    public void countReservas() {

    }

    public String toString(){
        return "Código de voo " + code+ ". " + plane.toString();
    }


   public String FlightCodetoString() {
        return "Código de voo " + code+ ". ";
    }
    
}
