package lab03.Voos;

import java.util.ArrayList;
import java.util.List;

public class Aviao {

    private List<Integer> E_Seats = new ArrayList<Integer>();
    private List<Integer> T_Seats = new ArrayList<Integer>();

    public Aviao(String E_Seats, String T_Seats) {
        String[] seatsE = E_Seats.split("x");

        this.E_Seats.add(Integer.parseInt(seatsE[0]));
        this.E_Seats.add(Integer.parseInt(seatsE[1]));


        seatsE = T_Seats.split("x");
        this.T_Seats.add(Integer.parseInt(seatsE[0]));
        this.T_Seats.add(Integer.parseInt(seatsE[1]));
    }

    public Aviao(String T_Seats) {
        String[] seats = T_Seats.split("x");
        this.T_Seats.add(Integer.parseInt(seats[0]));
        this.T_Seats.add(Integer.parseInt(seats[1]));
    }

    public int getE_Columns() {
        if(E_Seats.size() == 0){
            return 0;
        }
        return E_Seats.get(0);
    }

    public int getT_Columns() {
        return T_Seats.get(0);
    }

    public int getE_Seats() {
        if(E_Seats.size() == 0){
            return 0;
        }
        return E_Seats.get(0) * E_Seats.get(1);
    }

    public int getT_Seats() {

        return T_Seats.get(0) * T_Seats.get(1);
    }

    public int getNumFilas() {
        if (E_Seats.size() == 0)
            return T_Seats.get(1);
        else{
            if(T_Seats.get(1) > E_Seats.get(1)){
                return T_Seats.get(1);
            }

            return E_Seats.get(1);
        }       
    }

    public int getNumColunas() {
        if (E_Seats.size() == 0)
            return T_Seats.get(0);
        else{
            return E_Seats.get(0) + T_Seats.get(0);
        }       
    }

    // É suposto quando damos delete o numero de lugares available aumente? Ou como foi cancelado, aqueles lugares não podem mais ser ocupados?
    public void delReserve(int reserve_number) { // Será que é preciso distinguir entre os lugares iniciais e os lugares available?
        for (int i = 0; i < getE_Seats(); i++) {
            if (E_Seats.get(i) == reserve_number) {
            E_Seats(i) = 0;
            System.out.println(E_Seats);
            }
        }
        for (int i = 0; i < getT_Seats(); i++) {// Será que é preciso distinguir entre os lugares iniciais e os lugares available?
            if (T_Seats.get(i) == reserve_number) {
            T_Seats(i) = 0;
            System.out.println(T_Seats);
            }
        }
    }

    public String toString() {
        if (E_Seats.size() == 0) {
            return "Lugares disponíveis: " + getT_Seats() + " lugares em classe Turística.\nClasse executiva não disponível neste voo.";
        }
        return "Lugares disponíveis: " + getE_Seats() + " lugares em classe Executiva; " + getT_Seats() + " lugares em classe Turística.";
    }

    
}
