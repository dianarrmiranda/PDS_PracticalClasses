package lab03.Voos;

import java.util.ArrayList;
import java.util.List;

public class Aviao {

    private List<Integer> E_Seats = new ArrayList<Integer>();
    private List<Integer> T_Seats = new ArrayList<Integer>();
    private int numFilas;
    

    public Aviao(String E_Seats, String T_Seats) {
        String[] seatsE = E_Seats.split("x");

        this.E_Seats.add(Integer.parseInt(seatsE[0]));
        this.E_Seats.add(Integer.parseInt(seatsE[1]));


        seatsE = T_Seats.split("x");
        this.T_Seats.add(Integer.parseInt(seatsE[0]));
        this.T_Seats.add(Integer.parseInt(seatsE[1]));

        if(this.E_Seats.get(1) > this.T_Seats.get(1)){
            this.numFilas = this.E_Seats.get(1);
        }
        else{
            this.numFilas = this.T_Seats.get(1);
        }

    }

    public Aviao(String T_Seats) {
        String[] seats = T_Seats.split("x");
        this.T_Seats.add(Integer.parseInt(seats[0]));
        this.T_Seats.add(Integer.parseInt(seats[1]));
    }

    public int getE_Seats() {
        return E_Seats.get(0) * E_Seats.get(1);
    }

    public int getT_Seats() {
        return T_Seats.get(0) * T_Seats.get(1);
    }

    // public String getFlightCode(){
    //     return
    // }

    public String toString() {
        return "Lugares disponíveis: \n" + getE_Seats() + " lugares em executiva; " + getT_Seats() + " lugares em turística.";
    }

    
}
